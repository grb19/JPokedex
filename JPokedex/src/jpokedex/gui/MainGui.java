/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jpokedex.DesktopIntegrator;
import jpokedex.JPokedex;

/**
 *
 * @author grb19
 */
public class MainGui {
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public MainGui(Stage stage) throws IOException{
        @SuppressWarnings("UnusedAssignment")
        ResourceBundle guiBundle = null;
        try {
            guiBundle = ResourceBundle.getBundle("jpokedex.i18n.bundles.GuiBundle", Locale.ENGLISH);
        } catch (MissingResourceException e) {
            System.err.println("Bundle not found. Exiting" + e.getMessage());
            System.exit(-1);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainGui.fxml"), guiBundle);
        Parent root;
        root = (Parent) fxmlLoader.load(); //loads the gui
        MainGuiController mgc = (MainGuiController) fxmlLoader.getController();
        //mgc.initialize(null, pokeBundle);
        Scene scene = new Scene(root);
        stage.setTitle("JPokedex");
        stage.setScene(scene);
        stage.getIcons().add(new Image(JPokedex.class.getResourceAsStream("images/icon.png")));
        stage.show();
        mgc.setStatus(guiBundle.getString("statusmessages.sucessfullstart"));
    }
}