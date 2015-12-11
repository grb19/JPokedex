/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui;

import java.util.ArrayList;

/**
 * This class posesses all GuiControllers and handles calls to them.
 * @author grb19
 */
public class GuiControllerManager {
    static ArrayList<GuiController> guiControllerArray = new ArrayList<>();
    
    public static void setStatus(String status) {
        guiControllerArray.stream().forEach((guiController) -> 
            guiController.setStatus(status)
        );
    }

    public static void setBundleStatus(String status) {
        guiControllerArray.stream().forEach((guiController) -> 
            guiController.setBundleStatus(status)
        );
    }

    public static void setProgress(double progress) {
        guiControllerArray.stream().forEach((guiController) -> 
            guiController.setProgress(progress)
        );
    }
    
    public static void registerController(GuiController controller){
        guiControllerArray.add(controller);
    }
    
    public static void unregisterController(GuiController controller){
        guiControllerArray.remove(controller);
    }
    
}
