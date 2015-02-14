/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package javafx3dtest;

import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.stage.Stage;





/**
 *
 * @author grb19
 */
public class JavaFx3Dtest extends Application {
    private static final String Filename = "../data/3D models/001 - Bulbasaur/Bulbasaur.obj";
    
    private static final double MODEL_SCALE_FACTOR = 100;
    private static final double MODEL_X_OFFSET = 0; // standard
    private static final double MODEL_Y_OFFSET = 0; // standard
    
    private static final int VIEWPORT_SIZE = 800;
    
    
    private Group root;
    
    
    static MeshView[] loadMeshViews() {
        File file = new File(Filename);
        ObjModelImporter importer = new ObjModelImporter();
        importer.read(file);
        return importer.getImport();
    }
    
    
    private Group buildScene() {
        File file = new File(Filename);
        ObjModelImporter importer = new ObjModelImporter();
        importer.read(file);
        MeshView[] meshViews = importer.getImport();
        importer.close();
        for (MeshView meshView : meshViews) {
            meshView.setTranslateX(VIEWPORT_SIZE / 2 + MODEL_X_OFFSET);
            meshView.setTranslateY(VIEWPORT_SIZE / 2 + MODEL_Y_OFFSET);
            meshView.setTranslateZ(VIEWPORT_SIZE / 2);
        }
        
        root = new Group(meshViews);
        root.setScaleX(MODEL_SCALE_FACTOR);
        root.setScaleY(MODEL_SCALE_FACTOR);
        root.setScaleZ(MODEL_SCALE_FACTOR);
        
        return root;
    }
    @Override
    public void start(Stage stage) throws Exception {
        Group group = buildScene();
        
        Scene scene = new Scene(group, VIEWPORT_SIZE, VIEWPORT_SIZE, true);
        scene.setFill(Color.rgb(10, 10, 40));
        scene.setCamera(new PerspectiveCamera());
        stage.setTitle("JavaFx3Dtest");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
