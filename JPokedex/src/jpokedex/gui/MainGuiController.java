/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 *
 * @author grb19
 */
public class MainGuiController implements Initializable {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // Label used to display the current status
    private Label statusLabel;
    @FXML // ProgressBar, used to display work in progress
    private ProgressBar progressBar;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void setStatus(String text){
        statusLabel.setText(text);
    }
    
}
