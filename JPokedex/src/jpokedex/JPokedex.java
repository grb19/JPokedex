/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JPokedex is the main app of the JPokedex project.
 *
 * @author grb19
 */
public class JPokedex extends Application {
    
    /**
     * Initial method call to start the application.
     *
     * @param stage the primarystage of the application
     * @throws Exception
     */
    @Override
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void start(Stage stage) throws Exception {
        //clock = System.currentTimeMillis();
        Locale.setDefault(Locale.ENGLISH);
        @SuppressWarnings("UnusedAssignment")
        ResourceBundle pokeBundle = null;
        try {
            pokeBundle = ResourceBundle.getBundle("jpokedex.i18n.bundles.GuiBundle", Locale.ENGLISH);
        } catch (MissingResourceException e) {
            System.err.println("Bundle not found. Exiting" + e.getMessage());
            System.exit(-1);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainGui.fxml"), pokeBundle);
        Parent root = (Parent) fxmlLoader.load();//loads the gui
        MainGuiController mgc = (MainGuiController) fxmlLoader.getController();
        //mgc.initialize(null, pokeBundle);
        Scene scene = new Scene(root);
        stage.setTitle("JPokedex");
        stage.setScene(scene);
        stage.getIcons().add(new Image(JPokedex.class.getResourceAsStream("images/icon.png")));
        try {
            Class.forName("javax.jnlp.ServiceManager");
            new DesktopIntegrator();  //starts the desktop integrator. Used to ask for shortcuts.
        } catch (Exception e) {
            System.err.println("DesktopIntegrator not started:" + e.getMessage());
        }
        stage.show();
        mgc.setStatus("JPokedex successfully started");
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
