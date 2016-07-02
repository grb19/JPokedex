/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui;

import java.util.ArrayList;
import jpokedex.gui.desktop.GuiAttachable;
import jpokedex.gui.desktop.GuiDock;
import jpokedex.gui.desktop.MenuAttachable;
import jpokedex.gui.desktop.MenuDock;

/**
 * This class posesses all GuiControllers and handles calls to them.
 * @author grb19
 */
public class GuiControllerManager{
    static ArrayList<GuiController> guiControllerArray = new ArrayList<>();
    static ArrayList<GuiDock> guiDocks = new ArrayList<>();
    static ArrayList<MenuDock> menuDocks = new ArrayList<>();
    
    
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
        if (controller instanceof GuiDock){
            guiDocks.add((GuiDock) controller);
        }
        if (controller instanceof MenuDock){
            menuDocks.add((MenuDock) controller);
        }
    }
    
    public static void unregisterController(GuiController controller){
        guiControllerArray.remove(controller);
    }

    public static void attachGuiAttachable(int id, GuiAttachable attachable) {
        guiDocks.stream().forEach((dock) -> {
            dock.attachToPlane(id, attachable);
        });
    }

    public static void attachMenuAttachable(MenuAttachable attachable) {
        menuDocks.stream().forEach((dock) -> {
            dock.attachToMenu(attachable);
        });
    }
}
