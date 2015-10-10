/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex;

import java.io.IOException;
import javafx.stage.Stage;
import jpokedex.database.DatabaseController;
import jpokedex.gui.GuiController;
import jpokedex.gui.GuiFactory;
import jpokedex.gui.desktop.MainGui;

/**
 *
 * @author grb19
 */
public class JPokedexFactory {

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    JPokedexFactory(Stage stage) throws IOException {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        GuiFactory guiFactory = new GuiFactory(stage); // initializes the gui
        GuiController guiController = guiFactory.getGuiController();
        DatabaseController dbController = new DatabaseController(guiController);
        guiController.setDatabaseController(dbController);
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
    
}
