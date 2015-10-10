/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.database;

import java.io.Serializable;
import java.util.ArrayList;
import jpokedex.database.pokemon.PokemonDatabase;
import jpokedex.database.userdatabase.User;
import jpokedex.database.userdatabase.UserDatabase;

/**
 * This class manages the database of the application.
 * @author grb19
 */
class Database implements Serializable{
    private static final long serialVersionUID = 5520959720687483041L;
    
    /**
     * This holds the database of pokemon. Only a single instant is required
     */
    private PokemonDatabase pokemonDatabase;
    
    /**
     * This holds the UserDatabases. Since multiple users can exist,
     * multiple databases are necessary.
     */
    private ArrayList<UserDatabase> userDatabases;
    
    /**
     * This holds the users.
     */
    private ArrayList<User> users;
}
