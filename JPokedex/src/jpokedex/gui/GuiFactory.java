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
    public static void initialize(Stage stage) throws IOException {
        initializeDesktop(stage);
    }

    private static void initializeDesktop(Stage stage) throws IOException {
        MainGui gui = new MainGui(stage);//starts the main gui.
        GuiControllerManager.registerController(gui.getController());
    }
    
}
