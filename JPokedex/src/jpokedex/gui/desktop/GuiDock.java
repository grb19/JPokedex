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
public interface GuiDock {
    /**
     * Attaches a GuiAttachable to the plane with id id.
     * @param id specifies, where to attach the plane
     * @param attachable GuiAttachable to attach
     */
    public void attachToPlane(int id, GuiAttachable attachable);
}
