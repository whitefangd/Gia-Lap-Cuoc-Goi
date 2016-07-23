package com.boluclac.android.gialapcuocgoi.components.controls.clock;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.format.Time;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.boluclac.android.gialapcuocgoi.R;
import com.boluclac.android.gialapcuocgoi.common.CommonConstant;
import com.boluclac.android.gialapcuocgoi.common.CommonUtils;
import com.boluclac.android.gialapcuocgoi.components.controls.textviewex.UCTextViewIcon;

/**
 * User controls dong ho.
 * Gom cac thanh phan:
 * P1: constant
 * P2: field static
 * P3: field member
 * P4: static function
 * P5: constructor
 * P6: event function
 * P7: public function
 * P8: protected function
 * P9: private function
 * P10: properties function
 *
 * @author Le Thanh Dung
 */
public class UCClock extends FrameLayout implements UCClockBroadcastReceiver.ITimeTickListener {

    /**
     * P1: constant
     */
    /* format time. */
    private static final int UC_CLOCK_FORMAT_TIME = R.string.ValueUCClockFormatTime;
    /* format date. */
    private static final int UC_CLOCK_FORMAT_DATE = R.string.ValueUCClockFormatDate;

    private static final int UC_CLOCK_DAY_OF_WEEK = R.array.ValueUCCLockDayOfWeek;

    /* layout key. uc clock id. */
    private static final int LAYOUT_UC_CLOCK = R.layout.uc_clock;
    /* item key. text view clock id. */
    private static final int ITEM_LAYOUT_TEXTVIEW_CLOCK = R.id.text_view_clock;
    /* item key. text view morning or day icon id. */
    private static final int ITEM_LAYOUT_TEXTVIEW_MORNING_OR_NIGHT = R.id.text_view_morning_or_night;
    /* item key. text view date id. */
    private static final int ITEM_LAYOUT_TEXTVIEW_DATE = R.id.text_view_date;
    /* item key. text view day of week id. */
    private static final int ITEM_LAYOUT_TEXTVIEW_DAY_OF_WEEK = R.id.text_view_day_in_week;
    /** P2: field static */
    /** P3: field member */
    /**
     * Item member.
     */
    /* BroadcastReceiver for uc clock. */
    private UCClockBroadcastReceiver mIntentReceiver = null;
    /* flag Attached window */
    private boolean flagAttached = false;
    /* A Handler allows you to send and process {@link Message} and Runnable
     * objects associated with a thread's {@link MessageQueue} */
    private final Handler handler = new Handler();
    /**
     * Item layout
     */
    /* text view clock */
    private TextView textViewClock = null;
    /* text view clock */
    private TextView textViewDate = null;
    /* text view clock */
    private TextView textViewDayOfWeek = null;
    /* text view for icon morning or night. */
    private UCTextViewIcon textViewMorningOrNight = null;
    /** P4: static function */
    /** P5: constructor */
    /**
     * constructor #1
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public UCClock(final Context context) {
        super(context);
        initLayout();
        initEvent();
    }

    /**
     * constructor #2
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    public UCClock(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        initLayout();
        initEvent();
    }

    /**
     * constructor #3
     *
     * @param context  The Context the view is running in, through which it can
     *                 access the current theme, resources, etc.
     * @param attrs    The attributes of the XML tag that is inflating the view.
     * @param defStyle An attribute in the current theme that contains a
     *                 reference to a style resource to apply to this view. If 0, no
     *                 default style will be applied.
     */
    public UCClock(final Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout();
        initEvent();
    }
    /** P6: event function */
    /** P7: public function */
    /**
     * Broadcast Action: The current time has changed. Sent every minute.
     */
    @Override
    public void TimeTicket() {
        setDateTime();
    }
    /** P8: protected function */
    /**
     * This is called when the view is attached to a window.  At this point it
     * has a Surface and will start drawing.  Note that this function is
     * guaranteed to be called before {@link #onDraw(android.graphics.Canvas)},
     * however it may be called any time before the first onDraw -- including
     * before or after {@link #onMeasure(int, int)}.
     *
     * @see #onDetachedFromWindow()
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (!flagAttached) {
            flagAttached = true;
            IntentFilter filter = new IntentFilter();

            filter.addAction(Intent.ACTION_TIME_TICK);
            filter.addAction(Intent.ACTION_TIME_CHANGED);
            filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);

            getContext().registerReceiver(mIntentReceiver, filter, null, handler);
        }
    }

    /**
     * This is called when the view is detached from a window.  At this point it
     * no longer has a surface for drawing.
     *
     * @see #onAttachedToWindow()
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (flagAttached) {
            flagAttached = false;
            getContext().unregisterReceiver(mIntentReceiver);
        }
    }

    /** P9: private function */
    /**
     * Init layout. function lay thong tin item tren tren layout. va set value
     * init cho cac item can thiet.
     * function duoc goi function constructor:
     * {@link #UCClock(Context)}
     * {@link #UCClock(Context, AttributeSet)}
     * {@link #UCClock(Context, AttributeSet, int)}
     */
    private void initLayout() {
        //set layout.
        inflate(getContext(), LAYOUT_UC_CLOCK, this);
        this.mIntentReceiver = new UCClockBroadcastReceiver(this);
        //get item layout.
        textViewClock = (TextView) findViewById(ITEM_LAYOUT_TEXTVIEW_CLOCK);
        textViewDate = (TextView) findViewById(ITEM_LAYOUT_TEXTVIEW_DATE);
        textViewDayOfWeek = (TextView) findViewById(ITEM_LAYOUT_TEXTVIEW_DAY_OF_WEEK);
        textViewMorningOrNight = (UCTextViewIcon) findViewById(ITEM_LAYOUT_TEXTVIEW_MORNING_OR_NIGHT);

        //set value.
        setDateTime();
    }

    private void setDateTime() {
        String formatTime = getResources().getString(UC_CLOCK_FORMAT_TIME);
        String formatdate = getResources().getString(UC_CLOCK_FORMAT_DATE);
        String[] dayOfWeek = getResources().getStringArray(UC_CLOCK_DAY_OF_WEEK);

        Time now = CommonUtils.getSystemDateTime();

        textViewClock.setText(CommonUtils.convertTimeToString(now, formatTime));
        textViewDate.setText(CommonUtils.convertTimeToString(now, formatdate));
        textViewDayOfWeek.setText(dayOfWeek[now.weekDay]);
        textViewMorningOrNight.setMorningNight(CommonConstant.EMorningNight.getMorningOrNight(now));
    }

    /**
     * Init event. function bat su kien can thiet tren l
     * ayout.
     * function duoc goi function constructor:
     * {@link #UCClock(Context)}
     * {@link #UCClock(Context, AttributeSet)}
     * {@link #UCClock(Context, AttributeSet, int)}
     * function thuc hien ngay sau:
     * {@link #initLayout}
     */
    private void initEvent() {
        mIntentReceiver.addTimeTickListener(this);
    }
    /** P10: properties function */


}
