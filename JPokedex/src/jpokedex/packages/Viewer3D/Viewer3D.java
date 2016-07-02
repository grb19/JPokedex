/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.packages.Viewer3D;

import javafx.scene.Node;
import jpokedex.gui.desktop.GuiAttachable;
import jpokedex.packages.Package;

/**
 *
 * @author grb19
 */
public class Viewer3D extends Package implements GuiAttachable{
    public Viewer3D(){
    }

    @Override
    public Node getNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return "Viewer3D";
    }
}
