/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex;

import java.io.IOException;
import jpokedex.gui.MainGuiController;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jpokedex.gui.MainGui;

/**
 * JPokedex is the main app of the JPokedex project.
 *
 * @author grb19
 */
public class JPokedex extends Application {
    
    /**
     * Initial method call to start the application.
     *
     * @param stage the primary stage of the application
     * @throws java.io.IOException
     */
    @Override
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void start(Stage stage) throws IOException {
        //clock = System.currentTimeMillis();
        Locale.setDefault(Locale.ENGLISH);
        new MainGui(stage); //starts the main gui.
        try {
            Class.forName("javax.jnlp.ServiceManager");
            new DesktopIntegrator();  //starts the desktop integrator. Used to ask for shortcuts.
        } catch (Exception e) {
            System.err.println("DesktopIntegrator not started:" + e.getMessage());
        }
    }

    /**
     * Main method, that starts the program
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
