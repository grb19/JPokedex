/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.database;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpokedex.gui.GuiController;

/**
 *
 * @author grb19
 */
class DatabaseIODesktop implements DatabaseIO {

    private final String jPokedexName = "/.JPokedex/";
    private final String absolutePath;
    private final String databaseName = "database.jpdb";
    
    public DatabaseIODesktop(GuiController guiController) {
        absolutePath = System.getProperty("user.home") + jPokedexName;
        File theDir = new File(absolutePath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }

    @Override
    public Database loadDatabase() {
        System.out.println(absolutePath + databaseName);
        File theDB = new File(absolutePath + databaseName);
        if (theDB.exists()) {
            try {
                InputStream stream = new FileInputStream(theDB);
                InputStream buffer = new BufferedInputStream(stream);
                ObjectInput input = new ObjectInputStream(buffer);
                return (Database) input.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(DatabaseIODesktop.class.getName()).log(Level.SEVERE, null, ex);
                return new Database();
            }
        } else {
            return new Database();
        }
    }

    @Override
    public void saveDatabase(Database database) {
        File theDB = new File(absolutePath + databaseName);
        try {
            OutputStream stream = new FileOutputStream(theDB);
            OutputStream buffer = new BufferedOutputStream(stream);
            ObjectOutput output = new ObjectOutputStream(buffer);
            output.writeObject(database);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseIODesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
