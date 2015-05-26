/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.database.pokemon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author grb19
 */
public class PokemonTest {
    
    public PokemonTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Pokemon.
     */
    @Test
    public void testGetName_NoNameGiven() {
        System.out.println("getName no name given");
        Pokemon instance = new Pokemon();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Pokemon.
     */
    @Test
    public void testGetName_NameGiven() {
        System.out.println("getName name Given");
        Pokemon instance = new Pokemon("Pokemon");
        String expResult = "Pokemon";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
