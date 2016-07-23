package com.boluclac.android.gialapcuocgoi.components.controls.textviewex;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.boluclac.android.gialapcuocgoi.common.CommonConstant;

/**
 * User controls text view custom voi font chu dac biet cho ngay thang tren {@link com.boluclac.android.gialapcuocgoi.components.controls.clock.UCClock}
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
public class UCTextViewIcon extends TextView {

    /** P1: constant */
    /**
     * P2: field static
     */
    /* type font. */
    private static Typeface typeface = null;
    /**
     * P3: field member
     */
    /* Enum Ngay dem. */
    private CommonConstant.EMorningNight morningNight = CommonConstant.EMorningNight.getDefault();
    /** P4: static function */
    /** P5: constructor */

    /**
     * constructor #1
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public UCTextViewIcon(Context context) {
        super(context);
        initLayout();
    }

    /**
     * constructor #2
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    public UCTextViewIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout();
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
    public UCTextViewIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout();
    }
    /** P6: event function */
    /** P7: public function */
    /** P8: protected function */
    /** P9: private function */
    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }

    /**
     * Init layout. function lay thong tin item tren tren layout. va set value
     * init cho cac item can thiet.
     * function duoc goi function constructor:
     * {@link #UCTextViewIcon(Context)}
     * {@link #UCTextViewIcon(Context, AttributeSet)}
     * {@link #UCTextViewIcon(Context, AttributeSet, int)}
     */
    private void initLayout() {
        if (!this.isInEditMode()) {
            this.setTypeface(UCTextViewIcon.getTypeFace(getContext()));
        }
    }
    /**
     * P10: properties function
     */

    /**
     * get property static font.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @return Typeface is font type.
     */
    private static Typeface getTypeFace(Context context) {
        if (UCTextViewIcon.typeface == null) {
            UCTextViewIcon.typeface = Typeface.createFromAsset(context.getAssets(), CommonConstant.EAssetsFonts.FONT_AWESOME.getFontPath());
        }
        return UCTextViewIcon.typeface;
    }

    /**
     * Enum Ngay dem
     *
     * @return EMorningNight.
     */
    public CommonConstant.EMorningNight getMorningNight() {
        return morningNight;
    }

    /**
     * set value Enum Ngay dem.
     *
     * @param morningNight EMorningNight
     */
    public void setMorningNight(CommonConstant.EMorningNight morningNight) {
        this.setText(morningNight.getIconKey());
        this.morningNight = morningNight;
    }
}
