/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.database;

/**
 * Interface for input/output operations on databases. 
 * @author grb19
 */
interface DatabaseIO {
    public Database loadDatabase();
    public void saveDatabase(Database database);
}
