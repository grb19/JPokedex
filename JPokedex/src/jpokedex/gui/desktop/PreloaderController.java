/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui.desktop;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.application.Preloader.PreloaderNotification;
import jpokedex.database.DatabaseController;
import jpokedex.gui.GuiController;

/**
 *
 * @author grb19
 */
public class PreloaderController implements GuiController {

    Application app;

    public PreloaderController(Application app) {
        this.app = app;
    }

    @Override
    public void setStatus(String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBundleStatus(String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDatabaseController(DatabaseController dbController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBundle(ResourceBundle bundle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProgress(double progress) {
        app.notifyPreloader(new Preloader.ProgressNotification(progress));
    }

}
