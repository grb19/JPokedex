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

    /**
     * Stores the values of the internationalized object and its corresponding
     * locales.
     */
    HashMap<Locale, T> map;

    /**
     * Construct an internationalized object from one initial object. This
     * object will be put to the default locale.
     *
     * @param obj object, that is to be added
     */
    public I18nObj(T obj) {
        map = new HashMap<>();
        if (obj != null) {
            map.put(Locale.getDefault(), obj);
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
        if (locale == null || obj == null) {
            return;
        }
        if (map.containsKey(locale)) {
            throw new AlreadyExistentException("The locale " + locale.toString()
                    + ", to which you want to add data is already existent.");
        }
        map.put(locale, obj);
    }

    /**
     * Adds the specified object to the internationalized object. Uses the
     * default locale. If the object already exists, this method throws an
     * AlreadyExistentException. If you do not want that, use set() instead.
     *
     * @param obj Object, that is to be inserted.
     * @throws AlreadyExistentException is thrown, when the object already
     * exists.
     */
    public void add(T obj) throws AlreadyExistentException {
        add(Locale.getDefault(), obj);
    }

    /**
     * Gets the object of the specified locale. If the object corresponding to
     * the specified locale is not found, it uses the default locale. If this is
     * also not found, it uses the first entry of the map. If the map is empty,
     * this throws a NotExistentException.
     *
     * @param locale the locale, under which the object should be found.
     * @return the object that corresponds to the specified locale.
     * @throws NotExistentException is thrown, when the object does not exist.
     */
    public T get(Locale locale) throws NotExistentException {
        if (locale == null) {
            throw new NotExistentException("Locale is null.");
        }
        if (map.isEmpty()) {
            throw new NotExistentException("There is no entry in the map.");
        }
        if (map.containsKey(locale)) {
            return map.get(locale);
        }
        if (map.containsKey(Locale.getDefault())) {
            return map.get(Locale.getDefault());
        }
        return map.get(map.keySet().iterator().next());
    }

    /**
     * Gets the object of the default locale. If the object corresponding to the
     * specified locale is not found, it uses the first entry of the map. If the
     * map is empty, this throws a NotExistentException.
     *
     * @return the object that corresponds to the default locale.
     * @throws NotExistentException is thrown, when the object does not exist.
     */
    public T get() throws NotExistentException {
        return get(Locale.getDefault());
    }

    /**
     * Sets the value of the object under the specified locale.
     *
     * @param locale the locale, under which the object is set.
     * @param obj object, that is to be set.
     */
    public void set(Locale locale, T obj) {
        if (locale != null && obj != null) {
            map.put(locale, obj);
        }
    }

    /**
     * Sets the value of the object under the default locale.
     *
     * @param obj object, that is to be set.
     */
    public void set(T obj) {
        set(Locale.getDefault(), obj);
    }
}
