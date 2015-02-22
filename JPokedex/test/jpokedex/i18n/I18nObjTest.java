/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.i18n;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpokedex.exceptions.AlreadyExistentException;
import jpokedex.exceptions.NotExistentException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author grb19
 */
public class I18nObjTest {

    I18nObj<String> i18nString;

    public I18nObjTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        i18nString = new I18nObj<>("Hello");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class I18nObj.
     */
    @Test
    public void testAdd_Locale_GenericType() {
        System.out.println("add");
        try {
            i18nString.add(Locale.GERMAN, "Hallo");
        } catch (AlreadyExistentException e) {
            fail("Could not add Hallo to german locale.");
        }
        try {
            i18nString.add(new Locale("en"), "Hello");
        } catch (AlreadyExistentException e) {
            System.out.println("success");
            return;
        }
        fail("It should not reach until here.");
    }

    /**
     * Test of add method, of class I18nObj.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        try {
            i18nString.add("Hello");
        } catch (AlreadyExistentException e) {
            System.out.println("success");
            return;
        }
        fail("It should not reach until here.");
    }

    /**
     * Test of get method, of class I18nObj.
     */
    @Test
    public void testGet_Locale() {
        String s="";
        try {
            s=i18nString.get(Locale.ENGLISH);
        } catch (NotExistentException ex) {
            fail("failed getting string");
        }
        assertEquals(s, "Hello");
        try {
            s=i18nString.get(Locale.FRENCH);
        } catch (NotExistentException ex) {
            fail("failed getting string");
        }
        assertEquals(s, "Hello");
        i18nString.set(Locale.GERMAN,"Hallo");
        try {
            s=i18nString.get(Locale.GERMAN);
        } catch (NotExistentException ex) {
            fail("failed getting string");
        }
        assertEquals(s, "Hallo");
        
    }

    /**
     * Test of get method, of class I18nObj.
     */
    @Test
    public void testGet() {
        String s="";
        try {
            s=i18nString.get();
        } catch (NotExistentException ex) {
            fail("failed getting string");
        }
        assertEquals(s, "Hello");
    }
}
