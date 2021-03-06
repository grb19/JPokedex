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
import jpokedex.gui.GuiFactory;
import jpokedex.gui.desktop.PreloaderController;
import jpokedex.gui.GuiController;

/**
 *
 * @author grb19
 */
public class JPokedexFactory {
    GuiController guiController;
    DatabaseController dbController;

    JPokedexFactory(Application app) {
        guiController = new PreloaderController(app);
        
        dbController = new DatabaseController();
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

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    void initializeStage(Stage stage) throws IOException {
        GuiFactory.initialize(stage); // initializes the gui
    }
    
}
