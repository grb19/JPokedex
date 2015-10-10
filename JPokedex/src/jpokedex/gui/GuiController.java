/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui;

import java.util.ResourceBundle;
import jpokedex.database.DatabaseController;

/**
 *
 * @author grb19
 */
public interface GuiController {    
    /**
     * Sets a status message, could be displayed somehow or written to a log.
     * @param status 
     */
    public void setStatus(String status);
    
    /**
     * Sets a status message, interprets the text as bundle values. 
     * Could be displayed somehow or written to a log.
     * 
     * @param status 
     */
    public void setBundleStatus(String status);
    
    /**
     * Sets the dbController. Implementing class should store this somehow.
     * @param dbController 
     */
    public void setDatabaseController(DatabaseController dbController);
    
    public void setBundle(ResourceBundle bundle);
}
