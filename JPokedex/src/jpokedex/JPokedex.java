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
        Locale.setDefault(Locale.ENGLISH);
        ResourceBundle pokeBundle = null;
        try {
            pokeBundle = ResourceBundle.getBundle("jpokedex.i18n.bundles.GuiBundle", Locale.ENGLISH);
        } catch (MissingResourceException e) {
            System.out.println("Bundle not found. Exiting");
            System.exit(-1);
        }
        Parent root = FXMLLoader.load(getClass().getResource("MainGui.fxml"), pokeBundle);//loads the gui
        Scene scene = new Scene(root);
        stage.setTitle("JPokedex");
        stage.setScene(scene);
        stage.getIcons().add(new Image(JPokedex.class.getResourceAsStream("images/icon.png")));
        try {
            Class.forName("javax.jnlp.ServiceManager");
            new DesktopIntegrator();//starts the desktop integrator. Used to ask for shortcuts.
        } catch (Exception e) {
            System.out.println("DesktopIntegrator not started:" + e.getMessage());
        }
        stage.show();
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
