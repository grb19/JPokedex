/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui.desktop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import jpokedex.gui.GuiController;

/**
 *
 * @author grb19
 */
public class MainGuiController implements Initializable, GuiController, GuiDock, MenuDock {

    @FXML
    private ResourceBundle resources; ///< ResourceBundle that was given to the FXMLLoader
    @FXML
    private Label statusLabel; ///< Label used to display the current status
    @FXML
    private ProgressBar progressBar; ///< ProgressBar, used to display work in progress
    @FXML
    private TabPane tabPaneMain; ///< TabPane that defines the main view components
    @FXML
    private TabPane tabPaneRight; ///< TabPane on the right.
    @FXML
    private MenuBar mainMenuBar; ///< TabPane on the right.

    ResourceBundle bundle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resources = rb;
    }

    @Override
    public void setStatus(String text) {
        statusLabel.setText(text);
    }

    @Override
    public void setBundleStatus(String status) {
        setStatus(bundle.getString(status));
    }

    @Override
    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public void setProgress(double progress) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void attachToPlane(int id, GuiAttachable attachable) {
        //TODO: extend for different id's
        Tab tab = new Tab();
        tab.setText(attachable.getName());
        tab.setContent(attachable.getNode());
        tabPaneMain.getTabs().add(tab);
    }

    @Override
    public void attachToMenu(MenuAttachable attachable) {
        for (Menu m : mainMenuBar.getMenus()) {
            if (m.getText() == null ? attachable.getMainMenuName() == null : m.getText().equals(attachable.getMainMenuName())) {
                m.getItems().addAll(attachable.getMenuItems());
                return;
            }
        }
        // if not attached, add menu.
        Menu menu = new Menu(attachable.getMainMenuName());
        menu.getItems().addAll(attachable.getMenuItems());
        mainMenuBar.getMenus().add(menu);

    }

}
