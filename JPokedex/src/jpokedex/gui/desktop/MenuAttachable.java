/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui.desktop;

import java.util.Collection;
import javafx.scene.control.MenuItem;

/**
 *
 * @author grb19
 */
public interface MenuAttachable {
    public Collection<MenuItem> getMenuItems();

    public String getMainMenuName();
}
