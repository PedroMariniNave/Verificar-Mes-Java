package com.pedromarini.exercicio.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.StringUtils;

public final class DateUtils {

    private static final String DAY = "dd";
    private static final String MONTH = "MM";
    private static final String YEAR = "yyyy";
    private static final String DATE_FORMAT = StringUtils.joinWith("/", new String[] { DAY, MONTH, YEAR });

    public static boolean isValid(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);
        boolean valid = false;
        try {
            dateFormat.parse(date);
            valid = true;
        } catch (ParseException ex) {
            // ignore
        }

        return valid;
    }

    public static String getDateString(int day, int month, int year) {
        return StringUtils.replaceEach(DATE_FORMAT, new String[]{
                DAY,
                MONTH,
                YEAR
        }, new String[]{
                String.valueOf(day),
                String.valueOf(month),
                String.valueOf(year)
        });
    }
}