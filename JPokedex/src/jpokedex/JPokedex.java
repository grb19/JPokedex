/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JPokedex is the main app of the JPokedex project.
 * @author grb19
 */
public class JPokedex extends Application {
    /**
     * start gets called, when application is launched
     * @param stage the primarystage of the application
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("JPokedex");
        stage.setScene(scene);
        stage.getIcons().add(new Image(JPokedex.class.getResourceAsStream("images/icon.png")));
        //checkForShortcut();
        stage.show();
    }

   /**
    * Main method, that starts the program
    * @param args 
    */
    public static void main(String[] args) {
        launch(args);
    }

    /*private void checkForShortcut() {
        IntegrationService is;
        try{
            is=(IntegrationService) ServiceManager.lookup("javax.jnlp.IntegrationService");
        }catch(UnavailableServiceException e){
            return;
        }
        if(!is.hasDesktopShortcut()){
            if(!is.requestShortcut(true, true, "JPokedex")){
                System.out.println("shortcuts not created sucessfully");
            }
            else{
                System.out.println("shortcuts created sucessfully");
            }
        }else{
            System.out.println("already existent");
        }
    }*/
}
