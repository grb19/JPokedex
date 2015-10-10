/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.database;

import jpokedex.gui.GuiController;

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
    private final GuiController guiController;

    /**
     * Constructor of DatabaseController. Will load Database.
     *
     * @param guiController
     */
    public DatabaseController(GuiController guiController) {
        this.guiController = guiController;
        databaseIO = new DatabaseIODesktop();
        database = databaseIO.loadDatabase();
        guiController.setBundleStatus("statusmessages.successfulDatabaseLoad");
    }
}
