/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedexpreloader;

import javafx.application.Preloader;
import javafx.application.Preloader.PreloaderNotification;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author grb19
 */
public class JPokedexPreloader extends Preloader {

    ProgressBar bar;
    Label label;
    Stage stage;
    double appload = 0.1;

    private Scene createPreloaderScene() {
        bar = new ProgressBar();
        VBox vBox = new VBox();
        vBox.setBackground(Background.EMPTY);
        label = new Label("JPokedexPreloader started...");
        //label.setStyle("-fx-background-color: white;");
        Image img = new Image(JPokedexPreloader.class.getResourceAsStream("images/unown-juliet_orig.gif"));
        vBox.getChildren().addAll(new ImageView(img), bar, label);
        Scene s = new Scene(vBox);
        s.setFill(null);
        return s;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene());
        stage.getIcons().add(new Image(JPokedexPreloader.class.getResourceAsStream("images/icon.png")));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        centerOnScreen(stage);
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification scn) {
        if (scn.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }

    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        bar.setProgress(pn.getProgress() * appload);
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        if (info instanceof ProgressNotification) {
            double p = ((ProgressNotification) info).getProgress();
            bar.setProgress(appload + p * (1 - appload));
        }
        else if (info instanceof ProgressTextNotification){
            String t = ((ProgressTextNotification) info).getText();
            label.setText(t);
        }
    }

    private void centerOnScreen(Stage stage) {
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double centerX = bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) * .5;
        double centerY = bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) * .5;
        stage.setX(centerX);
        stage.setY(centerY);
    }
}

