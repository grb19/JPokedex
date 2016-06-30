/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui;

import java.util.ResourceBundle;

/**
 *
 * @author grb19
 */
public interface GuiController {

    /**
     * Sets a status message, could be displayed somehow or written to a log.
     *
     * @param status
     */
    public void setStatus(String status);

    /**
     * Sets a status message, interprets the text as bundle values. Could be
     * displayed somehow or written to a log.
     *
     * @param status
     */
    public void setBundleStatus(String status);

    /**
     * Sets the bundle. Needed to switch languages.
     *
     * @param bundle
     */
    public void setBundle(ResourceBundle bundle);

    /**
     * Sets a progress of a progress bar or something similar.
     *
     * @param progress
     */
    public void setProgress(double progress);
    
}
