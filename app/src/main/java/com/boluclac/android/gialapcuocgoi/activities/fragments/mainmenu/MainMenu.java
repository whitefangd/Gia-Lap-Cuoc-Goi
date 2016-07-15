package com.boluclac.android.gialapcuocgoi.activities.fragments.mainmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boluclac.android.gialapcuocgoi.R;

/**
 * {@link Fragment} dung de hien thi cho phan left menu.
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
public class MainMenu extends Fragment {

    /** P1: constant. */
    /* layout key. Main menu. */
    private static final int LAYOUT_FRAGMENT_MAIN_MENU = R.layout.fragment_main_menu;
    /** P2: field static */
    /** P3: field member */
    /**  P4: static function */
    /**  P5: constructor */
    /**
     * constructor #1.
     * Khong lam gi ca. dung de tranh su dung ham constructor cua class cha:
     * {@link Fragment#Fragment()}
     */
    public MainMenu() {
        //TODO: do nothing.
    }
    /**  P6: event function */
    /**  P7: public function */
    /**
     * Tham khao huong dan o: {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(LAYOUT_FRAGMENT_MAIN_MENU, container, false);
    }
    /**  P8: protected function */
    /**  P9: private function */
    /**
     * P10: properties function
     */
}
