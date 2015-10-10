/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex;

import java.io.IOException;
import javafx.application.Application;
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
     * @param stage the primary stage of the application
     * @throws java.io.IOException
     */
    @Override
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void start(Stage stage) throws IOException {
        new JPokedexFactory(stage);
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
