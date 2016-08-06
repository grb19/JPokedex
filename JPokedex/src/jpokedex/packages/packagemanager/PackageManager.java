/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.packages.packagemanager;

import java.util.ArrayList;
import java.util.Collection;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import jpokedex.gui.GuiControllerManager;
import jpokedex.gui.desktop.MenuAttachable;
import jpokedex.packages.JPokedexPackage;
import jpokedex.packages.Viewer3D.Viewer3D;

/**
 *
 * @author grb19
 */
public class PackageManager implements MenuAttachable {

    public PackageManager() {
        GuiControllerManager.attachMenuAttachable(this);
    }

    @Override
    public Collection<MenuItem> getMenuItems() {
        MenuItem item = new MenuItem("PackageManager");
        item.setOnAction((ActionEvent e) -> {
            assert (e.getEventType() == ActionEvent.ACTION);
            System.out.println("Opening PackageManager..." + e.getEventType().toString());
            
        });
        return java.util.Arrays.asList(item);
    }

    private ArrayList<String> getPackageNames() {
        ArrayList<String> packageNames = new ArrayList<>();
        packageNames.add("Viewer3D");
        return packageNames;
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private void activatePackage(String name){
        if ("Viewer3D".equals(name)){
            new Viewer3D();
        }
    }
    
    @Override
    public String getMainMenuName() {
        return "Options";
    }
}
