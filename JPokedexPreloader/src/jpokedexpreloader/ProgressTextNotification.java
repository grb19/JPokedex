/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedexpreloader;

import javafx.application.Preloader.PreloaderNotification;

/**
 *
 * @author grb19
 */
public class ProgressTextNotification implements PreloaderNotification {

    String text;

    public ProgressTextNotification(String status) {
        text = status;
    }

    public String getText() {
        return text;
    }

}
