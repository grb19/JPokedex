/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui.desktop;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jpokedex.JPokedex;
import jpokedex.i18n.I18nManager;
import jpokedex.gui.GuiController;

/**
 *
 * @author grb19
 */
public class MainGui {
    private final MainGuiController mgc;
    
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public MainGui(Stage stage) throws IOException {
        @SuppressWarnings("UnusedAssignment")
        ResourceBundle guiBundle = null;
        try {
            guiBundle = ResourceBundle.getBundle("jpokedex.i18n.bundles.GuiBundle",
                    I18nManager.getDefaultLocale());
        } catch (MissingResourceException e) {
            System.err.println("Bundle not found. Exiting" + e.getMessage());
            System.exit(-1);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainGui.fxml"), guiBundle);
        Parent root;
        root = (Parent) fxmlLoader.load(); //loads the gui
        mgc = (MainGuiController) fxmlLoader.getController();
        //mgc.initialize(null, pokeBundle);
        Scene scene = new Scene(root);
        stage.setTitle("JPokedex");
        stage.setScene(scene);
        stage.getIcons().add(new Image(JPokedex.class.getResourceAsStream("images/icon.png")));
        stage.show();
        mgc.setBundle(guiBundle);
        mgc.setBundleStatus("statusmessages.successfulstart");
    }
    
    public GuiController getController(){
        return mgc;
    }
}
