/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui.desktop;

import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import jpokedex.database.DatabaseController;
import jpokedex.gui.GuiController;
import jpokedex.i18n.I18nManager;

/**
 *
 * @author grb19
 */
public class MainGuiController implements Initializable, GuiController {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // Label used to display the current status
    private Label statusLabel;
    @FXML // ProgressBar, used to display work in progress
    private ProgressBar progressBar;
    
    ResourceBundle bundle;
    protected DatabaseController databaseController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @Override
    public void setStatus(String text){
        statusLabel.setText(text);
    }
    
    @Override
    public void setDatabaseController(DatabaseController dbController){
        databaseController = dbController;
    }

    @Override
    public void setBundleStatus(String status) {
        setStatus(bundle.getString(status));
    }
    
    /**
     * Sets the bundle
     * @param bundle
     */
    @Override
    public void setBundle(ResourceBundle bundle){
        this.bundle = bundle;
    }
    
}
