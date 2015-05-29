/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.i18n;

import java.util.ArrayList;
import java.util.Locale;

/**
 * This is a manager, that holds a ranking of the locales. It is used to get the
 * default locale, as well as possible second or third favorite languages. It
 * also allows to set specific mouse over languages (e.g. japanese romaji for
 * japanese kanji).
 *
 * @author grb19
 */
public class I18nManager {

    private static ArrayList<Locale> locales = new ArrayList<>();

    /**
     * This method sets the default locale. If the locale is already existing,
     * then the locale is moved to the front.
     *
     * @param defaultLocale the locale to be set as default locale.
     */
    public static void setDefaultLocale(Locale defaultLocale) {
        if (defaultLocale == null) {
            return;
        }
        if (locales.contains(defaultLocale)) {
            locales.remove(defaultLocale);
        }
        locales.add(0, defaultLocale);
    }

    /**
     * This method returns the default locale. If no locale is set until now,
     * Locale.ENGLISH is used.
     *
     * @return Default locale is returned. This is Locale.ENGLISH, if no other
     * locale has been set.
     */
    public static Locale getDefaultLocale() {
        if (locales.isEmpty()) {
            locales.add(Locale.ENGLISH);
        }
        return locales.get(0);
    }

    /**
     * This method returns the preferred locales. It returns the ArrayList with
     * the saved locales in the stored order.
     *
     * @return Stand-in locales.
     */
    public static ArrayList<Locale> getPreferredLocales() {
        return locales;
    }

    /**
     * This method sets the preferred locales. This should be ordered ranking
     * the most favorite to the least favorite.
     *
     * @param newLocales locales to be set
     */
    public static void setPreferredLocales(ArrayList<Locale> newLocales) {
        if (newLocales == null) {
            return;
        }
        locales = newLocales;
    }
}
