package com.boluclac.android.gialapcuocgoi.components.controls.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.boluclac.android.gialapcuocgoi.R;
import com.boluclac.android.gialapcuocgoi.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * User controls cho phan header
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
public class UCToolBar extends LinearLayout implements View.OnClickListener {

    /**
     * P1: constant
     */
    /* layout key. uc toolbar id. */
    private static final int LAYOUT_UC_TOOLBAR = R.layout.uc_toolbar;
    /* item key. Button menu id. */
    private static final int ITEM_LAYOUT_MENU_BUTTON = R.id.menu_button;

    /**  P2: field static */
    /**  P3: field member */

    /**
     * member event.
     */
    /* interface cho event click button me tren IUCToolBarMenu. */
    private List<IUCToolBarMenuClickListener> iucToolBarMenuClicksEventListener = new ArrayList<IUCToolBarMenuClickListener>();
    /**
     * Item layout
     */
    /* button function click menu. */
    private Button menu_button = null;

    /**  P4: static function */
    /**  P5: constructor */
    /**
     * constructor #1
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public UCToolBar(final Context context) {
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
    public UCToolBar(final Context context, final AttributeSet attrs) {
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
    public UCToolBar(final Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout();
        initEvent();
    }
    /**  P6: event function */

    /**
     * add event cho event click button menu tren IUCToolBarMenu
     * @param listener interface cho event click button menu tren IUCToolBarMenu
     */
    public void addOnUCToolBarMenuClickListener(final IUCToolBarMenuClickListener listener) {
        // add event.
        iucToolBarMenuClicksEventListener.add(listener);
    }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case ITEM_LAYOUT_MENU_BUTTON:
                eventMenuButtonClick(v);
                break;
        }
    }
    /**  P7: public function */
    /**  P8: protected function */
    /**  P9: private function */
    /**
     * Init layout. function lay thong tin item tren tren layout. va set value
     * init cho cac item can thiet.
     * function duoc goi function constructor:
     * {@link UCToolBar#UCToolBar(Context)}
     * {@link UCToolBar#UCToolBar(Context, AttributeSet)}
     * {@link UCToolBar#UCToolBar(Context, AttributeSet, int)}
     */
    private void initLayout() {
        //load layout
        inflate(getContext(), LAYOUT_UC_TOOLBAR, this);
        //get item layout
        menu_button = (Button) findViewById(ITEM_LAYOUT_MENU_BUTTON);
        //set value.
        if(!this.isInEditMode()) {
            menu_button.setTypeface(CommonUtils.getFontIcon(getContext()));
        }
    }

    /**
     * Init event. function bat su kien can thiet tren layout.
     * function duoc goi function constructor:
     * {@link UCToolBar#UCToolBar(Context)}
     * {@link UCToolBar#UCToolBar(Context, AttributeSet)}
     * {@link UCToolBar#UCToolBar(Context, AttributeSet, int)}
     * function thuc hien ngay sau:
     * {@link UCToolBar#initLayout}
     */
    private void initEvent() {
        //bat event onclick cho button menu_button_imageView
        menu_button.setOnClickListener(this);
    }

    /**
     * event button menu click.
     * Duoc goi khi button menu click
     *
     * @param v The view that was clicked.
     */
    private void eventMenuButtonClick(final View v) {
        //phat sinh su kien.
        if(iucToolBarMenuClicksEventListener != null) {
            for (IUCToolBarMenuClickListener listener : iucToolBarMenuClicksEventListener) {
                listener.onUCToolBarMenuClick(this);
            }
        }
    }
    /**
     * P10: properties function
     */
}
