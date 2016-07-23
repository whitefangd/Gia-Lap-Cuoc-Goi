package com.boluclac.android.gialapcuocgoi.common;

import android.text.format.Time;

/**
 * common class global
 * @author Le Thanh Dung
 */
public class CommonConstant {

    /**
     * private constructor
     */
    private CommonConstant () {
        throw new NullPointerException("CommonConstant only static");
    }
    /**
     * enum font in assets/fonts
     */
    public enum EAssetsFonts {
        /**
         * enum member.
         */
        /* Font Awesome. */
        FONT_AWESOME ("fonts/font-awesome.ttf"),
        /* Domino Font Family. */
        FONT_DOMINO_SHADOW ("fonts/font-domino-shadow.ttf"),
        /* Young and Beautiful. */
        FONT_YOUNG_AND_BEAUTIFUL ("fonts/font-young-and-beautiful.ttf"),
        /* Tabitha. */
        FONT_TABIHA ("fonts/font-tabitha.ttf");

        /* path fonts in assets. */
        private String fontPath;

        /**
         * constructor.
         * @param value path fonty.
         */
        EAssetsFonts(final String value) {
            this.fontPath = value;
        }

        /* get property. */
        public String getFontPath() {
            return this.fontPath;
        }
    }

    /**
     * Enum Ngay dem.
     */
    public enum EMorningNight {
        /* Morning. */
        MORNING("\uf185"),
        /* Night. */
        NIGHT("\uf186");

        /* time morning start. */
        private static final Time TIME_MORNING_START = new Time();
        /* time morning end. */
        private static final Time TIME_MORNING_END = new Time();

        /* Key for icon in font awesome. */
        private String iconKey;
        /**
         * get enum default.
         */
        public static EMorningNight getDefault() {
            return EMorningNight.MORNING;
        }

        /**
         * get time start for morning.
         * @return time morning start.
         */
        public static Time getTimeMorningStart() {
            TIME_MORNING_START.hour = 5;
            TIME_MORNING_START.minute = 0;

            return TIME_MORNING_START;
        }

        /**
         * get time end for morning.
         * @return time morning end.
         */
        public static Time getTimeMorningEnd() {
            TIME_MORNING_END.hour = 18;
            TIME_MORNING_END.minute = 0;

            return TIME_MORNING_END;
        }

        /**
         * get Enum Morning or Night for Time.
         * @param time time in day (only care hour and minute).
         * @return Enum key {@link CommonConstant.EMorningNight}
         */
        public static CommonConstant.EMorningNight getMorningOrNight(final Time time) {
            Time timeStart = CommonConstant.EMorningNight.getTimeMorningStart();
            Time timeEnd = CommonConstant.EMorningNight.getTimeMorningEnd();

            int timeNumberStart = timeStart.hour*60 + timeStart.minute;
            int timeNumberEnd = timeEnd.hour*60 + timeEnd.minute;
            if(time != null) {
                int timenumber = time.hour*60 + time.minute;
                if( timenumber >= timeNumberStart && timenumber <= timeNumberEnd) {
                    return CommonConstant.EMorningNight.MORNING;
                } else {
                    return CommonConstant.EMorningNight.NIGHT;
                }
            } else {
                return null;
            }
        }

        /**
         * constructor.
         * @param valueParam icon key.
         */
        EMorningNight(final String valueParam) {
            this.iconKey = valueParam;
        }

        /**
         * get value.
         * @return icon key.
         */
        public String getIconKey() {
            return this.iconKey;
        }
    }

    public enum EIconFontKey {

    }
}
