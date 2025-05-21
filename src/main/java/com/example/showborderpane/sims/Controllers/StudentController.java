package com.example.showborderpane.sims.Controllers;

import com.example.showborderpane.sims.Controllers.CRUD.Add;
import com.example.showborderpane.sims.Controllers.CRUD.Delete;
import com.example.showborderpane.sims.Controllers.CRUD.Display;
import com.example.showborderpane.sims.Controllers.CRUD.Edit;
import com.example.showborderpane.sims.Controllers.CRUD.Reports;
import com.example.showborderpane.sims.Controllers.CRUD.Search;
import com.example.showborderpane.sims.Views.StudentView;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentController {

    private StudentView stdView;

    public StudentController(Stage stage) {
        stdView = new StudentView(stage);
    }

    public void showView() {
        stdView.show();
    }

    public static void addStudent(Stage stage, Scene scene) {
        Add.getAddStd(stage, scene);
    }

    public static void editStudent(Stage stage, Scene scene) {
        Edit.updateStd(stage, scene);
    }

    public static void deleteStudent(Stage stage, Scene scene) {
        Delete.removeStds(stage, scene);
    }

    public static void searchStudent(Stage stage, Scene scene) {
        Search.findStd(stage, scene);
    }

    public static void generateReports(Stage stage, Scene scene) {
        Reports.addReport(stage, scene);
    }

    public static void showStudents(Stage stage, Scene scene) {
        Display.displayStds(stage, scene);
    }
}