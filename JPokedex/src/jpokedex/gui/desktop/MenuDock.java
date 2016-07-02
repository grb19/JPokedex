/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui.desktop;

/**
 *
 * @author grb19
 */
public interface MenuDock {
    /**
     * Attaches a Menu to a menuBar.
     * @param attachable MenuAttachable to attach
     */
    public void attachToMenu(MenuAttachable attachable);
}
