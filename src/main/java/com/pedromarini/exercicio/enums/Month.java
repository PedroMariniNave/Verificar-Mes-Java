package com.pedromarini.exercicio.enums;

public enum Month {
    JANUARY("janeiro"),
    FEBRUARY("fevereiro"),
    MARCH("março"),
    APRIL("abril"),
    MAY("maio"),
    JUNE("junho"),
    JULY("julho"),
    AUGUST("agosto"),
    SEPTEMBER("setembro"),
    OCTOBER("outubro"),
    NOVEMBER("novembro"),
    DECEMBER("dezembro");

    private final String translation;

    Month(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public int getCalendarNumber() {
        return ordinal() + 1;
    }

    public static Month getByCalendarNumber(int number) {
        if (number < 0 || number > values().length) return null;

        return values()[number-1];
    }
}