/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.database;

import jpokedex.gui.GuiController;
import jpokedex.gui.GuiControllerManager;

/**
 * This class is used as main referral to access, add, modify or remove objects
 * from the database.
 *
 * @author grb19
 */
public final class DatabaseController {

    /**
     * Holds the instance of the database.
     */
    private final Database database;
    private final DatabaseIO databaseIO;

    /**
     * Constructor of DatabaseController. Will load Database.
     */
    public DatabaseController() {
        GuiControllerManager.setProgress(0.);
        GuiControllerManager.setBundleStatus("statusmessages.DatabaseLoading");
        databaseIO = new DatabaseIODesktop();///@TODO: put this in a factory
        database = databaseIO.loadDatabase();
        System.out.println("db loaded");
        GuiControllerManager.setProgress(1.);
        //guiController.setBundleStatus("statusmessages.successfulDatabaseLoad");
    }
}
