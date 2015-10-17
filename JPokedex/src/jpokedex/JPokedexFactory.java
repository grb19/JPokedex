/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import jpokedex.database.DatabaseController;
import jpokedex.gui.GuiController;
import jpokedex.gui.GuiFactory;
import jpokedex.gui.desktop.PreloaderController;

/**
 *
 * @author grb19
 */
public class JPokedexFactory {
    GuiController guiController;
    DatabaseController dbController;
    
    /*@SuppressWarnings("ResultOfObjectAllocationIgnored")
    JPokedexFactory(Stage stage) throws IOException {
        
    }*/

    JPokedexFactory(Application app) {
        guiController = new PreloaderController(app);
        dbController = new DatabaseController(guiController);
        initializeDesktopIntegration();
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private void initializeDesktopIntegration() {
        try {
            Class.forName("javax.jnlp.ServiceManager");
            new DesktopIntegrator();  //starts the desktop integrator. Used to ask for shortcuts.
        } catch (Exception e) {
            System.err.println("DesktopIntegrator not started: " + e.getMessage());
        }
    }

    void initializeStage(Stage stage) throws IOException {
        GuiFactory guiFactory = new GuiFactory(stage); // initializes the gui
        guiController = guiFactory.getGuiController();
        guiController.setDatabaseController(dbController);
    }
    
}
