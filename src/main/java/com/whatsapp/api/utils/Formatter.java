package com.whatsapp.api.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * custom text formatter
 */
public class Formatter {

    /**
     * Italic string.
     *
     * @param text String
     * @return text formatted in italic. Example: <i>"italic text"</i>
     */
    public static String italic(String text) {
        if (StringUtils.isBlank(text)) return text;
        String italic = "_";
        return italic + text + italic;
    }

    /**
     * Bold string.
     *
     * @param text String
     * @return bold formatted text. Example: <b>"bold text"</b>
     */
    public static String bold(String text) {
        if (StringUtils.isBlank(text)) return text;
        String bold = "*";
        return bold + text + bold;
    }

    /**
     * Strikethrough string.
     *
     * @param text String
     * @return strikethrough text. Example: strikethrough text"
     */
    public static String strikethrough(String text) {
        if (StringUtils.isBlank(text)) return text;
        String strikethrough = "~";
        return strikethrough + text + strikethrough;
    }

    /**
     * Code string.
     *
     * @param text String
     * @return text formatted as code. Example: <code>"code text"</code>
     */
    public static String code(String text) {
        if (StringUtils.isBlank(text)) return text;
        String code = "```";
        return code + text + code;
    }

}
