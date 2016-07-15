package com.boluclac.android.gialapcuocgoi.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

import com.boluclac.android.gialapcuocgoi.R;
import com.boluclac.android.gialapcuocgoi.components.controls.toolbar.IUCToolBarMenuClickListener;
import com.boluclac.android.gialapcuocgoi.components.controls.toolbar.UCToolBar;
import com.boluclac.android.gialapcuocgoi.activities.fragments.mainmenu.MainMenu;

/**
 * Activity hien thi khoi dau khi mo chuong trinh
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
public class MainActivity extends Activity implements IUCToolBarMenuClickListener {

    /** P1: constant. */
    /* layout key. activity main layout. */
    private static final int LAYOUT_ACTIVITY_MAIN = R.layout.activity_main;
    /* Item key. Main layout. */
    private static final int ITEM_LAYOUT_MAIN_LAYOUT = R.id.main_layout;
    /* Item key. Main menu (left menu. */
    private static final int ITEM_LAYOUT_FRAGMENT_MAIN_MENU = R.id.fragment_main_menu;
    /* Item key. Header uc toolbar. */
    private static final int ITEM_LAYOUT_VIEW_UC_TOOLBAR = R.id.view_uc_toolbar;
    /** P2: field static. */
    /**
     * P3: field member.
     */
    /* main layout. */
    private DrawerLayout mainLayout = null;
    /* Fragment Manager. */
    private FragmentManager manager = null;
    /* main menu (left menu). */
    private MainMenu fragmentMainMenu = null;
    /* Header uc toolbar. */
    private UCToolBar ucToolBarHeader = null;
    /** P4: static function. */
    /** P5: constructor. */
    /** P6: event function. */
    /**
     * funtion cho event khi click menu tren UCToolBar.
     *
     * @param ucToolBar
     */
    @Override
    public void onUCToolBarMenuClick(final UCToolBar ucToolBar) {
        //show main menu.
        mainLayout.openDrawer(Gravity.LEFT);
    }
    /** P7: public function. */
    /**
     * P8: protected function.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        //default init
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ACTIVITY_MAIN);
        // init load item.
        initLoadItem();
        // init load event.
        initLoadEvent();
    }
    /** P9: private function. */

    /**
     * init load item.
     * thu thap cac item tren layout phuc vu xu ly sau nay.
     */
    private void initLoadItem() {
        //main layout.
        mainLayout = (DrawerLayout) findViewById(ITEM_LAYOUT_MAIN_LAYOUT);
        mainLayout.setDrawerLockMode(DrawerLayout.FOCUSABLES_TOUCH_MODE);
        //Fragment Manager.
        manager = getFragmentManager();
        //main menu (left menu).
        fragmentMainMenu = (MainMenu) manager.findFragmentById(ITEM_LAYOUT_FRAGMENT_MAIN_MENU);
        //Header uc toolbar.
        ucToolBarHeader = (UCToolBar) findViewById(ITEM_LAYOUT_VIEW_UC_TOOLBAR);
    }

    /**
     * init load event
     * bat cac vent xu ly tren man hinh.
     */
    private void initLoadEvent() {
        //TODO: load cac thong tin event tren man hinh.
        ucToolBarHeader.addOnUCToolBarMenuClickListener(this);
    }
    /** P10: properties function. */
}
