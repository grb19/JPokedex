/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui;

import java.io.IOException;
import javafx.stage.Stage;
import jpokedex.gui.desktop.MainGui;

/**
 * Creates links between gui and controller. for multiple different factories:
 * make this one either abstract or interface and move implementations to GuiFactoryDesktop.
 * @author grb19
 */
public class GuiFactory {
    private final GuiController guiController;
    
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public GuiFactory(Stage stage) throws IOException {
        MainGui gui = new MainGui(stage);
        guiController = gui.getController(); //starts the main gui.
    }

    public GuiController getGuiController() {
        return guiController;
    }
    
}
