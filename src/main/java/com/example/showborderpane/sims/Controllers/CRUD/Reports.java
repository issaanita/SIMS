package com.example.showborderpane.sims.Controllers.CRUD;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Reports {

    private Stage studentStage;
    private Scene mainScene;

    public Reports(Stage sStage, Scene scene) {
        studentStage = sStage;
        mainScene = scene;
        createStdRep();
    }

    public static void addReport(Stage sStage, Scene scene) {
        new Reports(sStage, scene);
    }

    private void createStdRep() {
    }

}