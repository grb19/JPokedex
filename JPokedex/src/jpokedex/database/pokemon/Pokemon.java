/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.database.pokemon;

import java.io.Serializable;
import java.util.Locale;
import jpokedex.exceptions.NotExistentException;
import jpokedex.i18n.I18nObj;

/**
 * The Pokemon object represents a pokemon. Only the common data for all version
 * specific pokemons is saved in this class. Other information is saved in
 * PokemonVersioned objects. This class however has references to these objects.
 *
 * @author grb19
 */
public class Pokemon implements Serializable{
    private static final long serialVersionUID = 8904839225518892520L;

    I18nObj<String> name;
 
    public Pokemon(String name){
        this.name = new I18nObj<>(name);
    }
    public Pokemon(){
        this.name = new I18nObj<>();
    }
            
    
    /**
     * Returns the name of the Pokemon in the specific locale. If the name is
     * not found, it returns an empty String.
     *
     * @param locale the locale, for which the name is searched.
     * @return the searched name.
     */
    public String getName(Locale locale) {
        try {
            return name.get(locale);
        } catch (NotExistentException e) {
            return "";
        }
    }

    /**
     * Returns the name of the Pokemon in the default locale. If the name is not
     * found, it returns an empty String.
     *
     * @return the searched name.
     */
    public String getName() {
        return getName(Locale.getDefault());
    }
}
