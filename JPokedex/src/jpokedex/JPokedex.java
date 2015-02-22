/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JPokedex is the main app of the JPokedex project.
 * @author grb19
 */
public class JPokedex extends Application {
    /**
     * Initial method call to start the application. 
     * @param stage the primarystage of the application
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        ResourceBundle pokeBundle = ResourceBundle.getBundle("jpokedex.bundles.GuiBundle", new Locale("en","US"));
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"), pokeBundle);
        Scene scene = new Scene(root);
        stage.setTitle("JPokedex");
        stage.setScene(scene);
        stage.getIcons().add(new Image(JPokedex.class.getResourceAsStream("images/icon.png")));
        stage.show();
    }

   /**
    * Main method, that starts the program
    * @param args 
    */
    public static void main(String[] args) {
        launch(args);
    }
}
