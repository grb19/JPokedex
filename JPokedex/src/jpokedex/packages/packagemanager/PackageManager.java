/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.packages.packagemanager;

import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.control.MenuItem;
import jpokedex.gui.GuiControllerManager;
import jpokedex.gui.desktop.MenuAttachable;

/**
 *
 * @author grb19
 */
public class PackageManager implements MenuAttachable{
    public PackageManager(){
        GuiControllerManager.attachMenuAttachable(this);
    }

    @Override
    public Collection<MenuItem> getMenuItems() {
        MenuItem item=new MenuItem("PackageManager");
        return java.util.Arrays.asList(item);
    }

    @Override
    public String getMainMenuName() {
        return "Options";
    }
}
