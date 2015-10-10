/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.database;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grb19
 */
class DatabaseIODesktop implements DatabaseIO {
    
    
    public DatabaseIODesktop() {
    }

    @Override
    public Database loadDatabase() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DatabaseIODesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Database();
    }

    @Override
    public void saveDatabase(Database database) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
