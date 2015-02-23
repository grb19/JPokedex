/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.database.pokemon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpokedex.database.games.Game;
import jpokedex.exceptions.NotExistentException;
import jpokedex.i18n.I18nObj;

/**
 * 
 * @author grb19
 */
public class Pokedex implements Serializable{
    private I18nObj<String> name;
    private ArrayList<Game> games;
    private HashMap<Integer, Pokemon> pokedexEntries;
    
    
    
    public String getName() {
        try {
            return name.get();
        } catch (NotExistentException ex) {
            return "";
        }
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void addPokemon(int entry, Pokemon pokemon){
        pokedexEntries.put(entry, pokemon);
    }
    
}
