/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.i18n;

import java.io.Serializable;
import java.util.HashMap;
import jpokedex.exceptions.NotExistentException;
import jpokedex.exceptions.AlreadyExistentException;
import java.util.Locale;

/**
 * This class is used to give an easy method to save, set and retrieve
 * internationalized information. It is used for simple information. For more
 * complex information, bundles will be used.
 *
 * @author grb19
 * @param <T> This is the type the information is given in.
 */
public class I18nObj<T> implements Serializable {

    private static final long serialVersionUID = 7038162095269898022L;

    /**
     * Stores the values of the internationalized object and its corresponding
     * locales.
     */
    HashMap<Locale, T> map;

    /**
     * Construct an internationalized object from one initial object. This
     * object will be put to the default locale from I18nManager.
     *
     * @param obj object, that is to be added
     */
    public I18nObj(T obj) {
        map = new HashMap<>();
        if (obj != null) {
            map.put(I18nManager.getDefaultLocale(), obj);
        }
    }

    /**
     * Construct an empty initial object.
     */
    public I18nObj() {
        map = new HashMap<>();
    }

    /**
     * Adds the specified object to the internationalized object. Uses the
     * specified locale. If the object already exists, this method throws an
     * AlreadyExistentException. If you do not want that, use set() instead.
     *
     * @param locale the locale, under which the object is inserted.
     * @param obj object, that is to be inserted.
     * @throws AlreadyExistentException is thrown, when the object already
     * exists.
     */
    public void add(Locale locale, T obj) throws AlreadyExistentException {
        if (obj == null) {
            return;
        }
        if (locale == null) {
            locale = I18nManager.getDefaultLocale();
        }
        if (map.containsKey(locale)) {
            throw new AlreadyExistentException("The locale " + locale.toString()
                    + ", to which you want to add data is already existent.");
        }
        map.put(locale, obj);
    }

    /**
     * Adds the specified object to the internationalized object. Uses the
     * default locale from I18nManager. If the object already exists, this
     * method throws an AlreadyExistentException. If you do not want that, use
     * set() instead.
     *
     * @param obj Object, that is to be inserted.
     * @throws AlreadyExistentException is thrown, when the object already
     * exists.
     */
    public void add(T obj) throws AlreadyExistentException {
        add(I18nManager.getDefaultLocale(), obj);
    }

    /**
     * Sets the value of the object under the specified locale.
     *
     * @param locale the locale, under which the object is set.
     * @param obj object, that is to be set.
     */
    public void set(Locale locale, T obj) {
        if (obj != null) {
            if (locale == null) {
                locale = I18nManager.getDefaultLocale();
            }
            map.put(locale, obj);
        }
    }

    /**
     * Sets the value of the object under the default locale.
     *
     * @param obj object, that is to be set.
     */
    public void set(T obj) {
        set(I18nManager.getDefaultLocale(), obj);
    }

    /**
     * Gets the object of the specified locale. If the object corresponding to
     * the specified locale is not found, it throws a NotExistentException.
     *
     * @param locale the locale, under which the object should be found.
     * @return the object that corresponds to the specified locale.
     * @throws NotExistentException is thrown, when the object does not exist.
     */
    public T get(Locale locale) throws NotExistentException {
        if (locale == null) {
            locale = I18nManager.getDefaultLocale();
        }
        if (map.containsKey(locale)) {
            return map.get(locale);
        }
        throw new NotExistentException("There is no entry in the map with the"
                + "specified locale.");
    }

    /**
     * Gets the object of the default locale from I18nManager. If that object is
     * not found, this throws a NotExistentException.
     *
     * @return the object that corresponds to the default locale.
     * @throws NotExistentException is thrown, when the object does not exist.
     */
    public T get() throws NotExistentException {
        return get(I18nManager.getDefaultLocale());
    }

    /**
     * Gets the object of the specified locale. If the object corresponding to
     * the specified locale is not found, the preferred languages from the
     * I18nManager are used to determine suitable alternatives. If none of these
     * languages exist, this returns the first element added to the object. If
     * no object has ever been added, this returns a NotExistentException.
     *
     * @param locale the locale, under which the object should be found.
     * @return the object that corresponds to the specified locale.
     * @throws NotExistentException is thrown, when the internal map does not
     * contain an object, and thus no object has ever been added to this
     * I18nObject.
     */
    public T getFailSafe(Locale locale) throws NotExistentException {
        if (locale == null) {
            locale = I18nManager.getDefaultLocale();
        }
        if (map.isEmpty()) {
            throw new NotExistentException("Map is empty.");
        }

        if (map.containsKey(locale)) {
            return map.get(locale);
        }

        for (Locale loc : I18nManager.getPreferredLocales()) {
            if (map.containsKey(loc)) {
                return map.get(loc);
            }
        }

        return map.get(map.keySet().iterator().next());
    }

    /**
     * Gets the object of the default locale from the I18nManager. If the object
     * corresponding to the default locale is not found, the preferred languages
     * from the I18nManager are used to determine suitable alternatives. If none
     * of these languages exist, this returns the first element added to the
     * object. If no object has ever been added, this returns a
     * NotExistentException.
     *
     * @return the object that corresponds to the specified locale.
     * @throws NotExistentException is thrown, when the internal map does not
     * contain an object, and thus no object has ever been added to this
     * I18nObject.
     */
    public T getFailSafe() throws NotExistentException {
        return getFailSafe(I18nManager.getDefaultLocale());
    }
}
