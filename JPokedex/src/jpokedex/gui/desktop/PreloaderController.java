/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.gui.desktop;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Preloader;
import jpokedex.i18n.I18nManager;
import jpokedex.gui.GuiController;

/**
 *
 * @author grb19
 */
public class PreloaderController implements GuiController {

    Application app;
    ResourceBundle bundle;

    public PreloaderController(Application app) {
        this.app = app;
        bundle = ResourceBundle.getBundle("jpokedex.i18n.bundles.GuiBundle", I18nManager.getDefaultLocale());
    }

    @Override
    public void setStatus(String status) {
        app.notifyPreloader(new jpokedexpreloader.ProgressTextNotification(status));
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
        app.notifyPreloader(new Preloader.ProgressNotification(progress));
    }

}
