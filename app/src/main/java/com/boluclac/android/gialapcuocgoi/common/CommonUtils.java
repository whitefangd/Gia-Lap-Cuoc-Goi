package com.boluclac.android.gialapcuocgoi.common;

import android.content.Context;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.text.format.Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by BoLucLac on 7/15/2016.
 */
public class CommonUtils {
    /** system time. */
    private static Time mCalendar = null;
    /** Typeface font icon. */
    private static Typeface typeface = null;
    /**
     * private constructor
     */
    private CommonUtils () {
        throw new NullPointerException("CommonUtils only static");
    }

    /**
     * get property time system.
     */
    private static Time getMyCalendar() {
        if(mCalendar == null) {
            mCalendar = new Time();
        }
        return mCalendar;
    }

    /**
     * font icon.
     */
    public static Typeface getFontIcon(Context context) {
        if(typeface == null) {
            CommonUtils.typeface = Typeface.createFromAsset(context.getAssets(), CommonConstant.EAssetsFonts.FONT_AWESOME.getFontPath());
        }
        return CommonUtils.typeface;
    }

    public static void setTimeZone(final String timezone) {
        mCalendar = new Time(TimeZone.getTimeZone(timezone).getID());
    }

    /**
     * get System date time.
     */
    public static Time getSystemDateTime() {
        getMyCalendar().setToNow();
        return  getMyCalendar();
    }

    public static String convertTimeToString(Time now, String formatTime) {
        return now.format(formatTime);
    }
}
