package com.boluclac.android.gialapcuocgoi.common;

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
        FONT_YOUNG_AND_BEAUTIFUL ("fonts/font-young-and-beautiful.ttf");

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

    public enum EIconFontKey {

    }
}
