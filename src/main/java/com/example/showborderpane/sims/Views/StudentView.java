package com.example.showborderpane.sims.Views;

import com.example.showborderpane.sims.Main;
import com.example.showborderpane.sims.Controllers.StudentController;
import com.example.showborderpane.sims.Services.StudentService;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StudentView {

        private Stage studentStage;
        private Scene mainScene;
        private Label titleLabel;
        private GridPane dashboardGrid;
        private Button showAllStdBtn,
                        addStdBtn, editStdBtn,
                        deleteStdBtn, searchStdBtn, reportsBtn;

        final String selectedLanguage = Main.getLanguage();

        public StudentView(Stage pStage) {
                studentStage = pStage;
                // public Student() {
                // studentStage = new Stage();
                studentStage.setTitle("Students");
                studentStage.setHeight(500);
                studentStage.setWidth(950);
                studentStage.setX(340);
                studentStage.setY(150);
                studentStage.setResizable(true);

                VBox layout = new VBox(30);
                layout.setPadding(new Insets(20, 10, 10, 10));

                titleLabel = new Label();
                titleLabel.setStyle(
                                "-fx-text-fill: white; " +
                                                "-fx-font-size: 42px; " +
                                                "-fx-font-weight: bold; " +
                                                "-fx-padding: 20px 0; " +
                                                "-fx-font-family: 'Segoe UI', sans-serif; " +
                                                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0, 0, 10); " +
                                                "-fx-text-alignment: center;");

                GridPane buttonGrid = new GridPane();
                buttonGrid.setHgap(15);
                buttonGrid.setVgap(15);
                buttonGrid.setPadding(new Insets(10));

                showAllStdBtn = createStyledButton("Show All Students", "students.png");
                addStdBtn = createStyledButton("Add Student", "addStd.png");
                editStdBtn = createStyledButton("Edit Student Info", "editStd.png");
                deleteStdBtn = createStyledButton("Delete Student", "deleteStd.png");
                searchStdBtn = createStyledButton("Search Student", "search.png");
                reportsBtn = createStyledButton("Reports", "report.png");

                showAllStdBtn.setOnAction(e -> StudentController.showStudents(studentStage, mainScene));
                addStdBtn.setOnAction(e -> StudentController.addStudent(studentStage, mainScene));
                editStdBtn.setOnAction(e -> StudentController.editStudent(studentStage, mainScene));
                deleteStdBtn.setOnAction(e -> StudentController.deleteStudent(studentStage, mainScene));
                searchStdBtn.setOnAction(e -> StudentController.searchStudent(studentStage, mainScene));
                reportsBtn.setOnAction(e -> StudentController.generateReports(studentStage, mainScene));

                buttonGrid.add(showAllStdBtn, 0, 0);
                buttonGrid.add(addStdBtn, 1, 0);
                buttonGrid.add(editStdBtn, 0, 1);
                buttonGrid.add(deleteStdBtn, 1, 1);
                buttonGrid.add(searchStdBtn, 0, 2);
                buttonGrid.add(reportsBtn, 1, 2);

                Button mainMenuBtn = createStyledButton("Main Menu", "home.png");
                mainMenuBtn.setOnAction(e -> {
                        studentStage.close();
                        Main.goToMainUI(pStage);
                });
                buttonGrid.add(mainMenuBtn, 0, 3, 2, 1);
                GridPane.setHalignment(mainMenuBtn, HPos.CENTER);

                dashboardGrid = new GridPane();
                dashboardGrid.setHgap(30);
                dashboardGrid.setVgap(15);
                dashboardGrid.setAlignment(Pos.CENTER);
                dashboardGrid.setPadding(new Insets(10));

                layout.getChildren().addAll(titleLabel, dashboardGrid);
                layout.setAlignment(Pos.TOP_CENTER);

                mainScene = new Scene(layout, 600, 400);
                studentStage.setScene(mainScene);

                layout.setBackground(
                                new Background(new BackgroundFill(
                                                Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5),
                                                null, Insets.EMPTY)));

                dashboardGrid.add(buttonGrid, 1, 0, 1, 2);

                if (selectedLanguage.equals("English")) {
                        titleLabel.setText("Student Dashboard");

                        showAllStdBtn.setText("Show All Students");
                        addStdBtn.setText("Add Student");
                        editStdBtn.setText("Edit Student Info");
                        deleteStdBtn.setText("Delete Student");
                        searchStdBtn.setText("Search Student");
                        reportsBtn.setText("Reports");

                        dashboardGrid.add(
                                        createDashboardCard("Total Classes",
                                                        String.valueOf(StudentService.getTotalClasses()),
                                                        "Teal", "calendar.png"),
                                        0, 0);
                        dashboardGrid.add(createDashboardCard("Total Students",
                                        String.valueOf(StudentService.getTotalStudents()),
                                        "Teal", "students.png"), 0, 1);

                        dashboardGrid.add(createDashboardCard("Total Stds Under Probation",
                                        String.valueOf(StudentService.getTotalProbation()), "IndianRed", "warning.png"),
                                        2, 0);
                        dashboardGrid.add(createDashboardCard("Total Penalties",
                                        String.valueOf(StudentService.getTotalPenalties()),
                                        "IndianRed", "penalty.png"), 2, 1);

                        mainMenuBtn.setText("Log out");

                } else if (selectedLanguage.equals("Arabic")) {
                        titleLabel.setText("معلومات الطلاب");

                        showAllStdBtn.setText("عرض جميع الطلاب");
                        addStdBtn.setText("إضافة طالب");
                        editStdBtn.setText("تعديل معلومات الطالب");
                        deleteStdBtn.setText("حذف طالب");
                        searchStdBtn.setText("ابحث عن طالب");
                        reportsBtn.setText("تقارير");

                        dashboardGrid.add(createDashboardCard("مجموع الصفوف",
                                        String.valueOf(StudentService.getTotalClasses()),
                                        "Teal", "calendar.png"), 0, 0);
                        dashboardGrid.add(
                                        createDashboardCard("مجموع الطلاب",
                                                        String.valueOf(StudentService.getTotalStudents()),
                                                        "Teal", "students.png"),
                                        0,
                                        1);

                        dashboardGrid.add(createDashboardCard("مجموع الطلاب تحت المراقبة",
                                        String.valueOf(StudentService.getTotalProbation()), "IndianRed", "warning.png"),
                                        2, 0);
                        dashboardGrid.add(createDashboardCard("مجموع العقوبات",
                                        String.valueOf(StudentService.getTotalPenalties()),
                                        "IndianRed", "penalty.png"), 2, 1);

                        mainMenuBtn.setText("تسجيل الخروج");
                }
        }

        public void show() {
                studentStage.show();
        }

        private VBox createDashboardCard(String title, String value, String color, String iconPath) {
                VBox card = new VBox(10);
                card.setPadding(new Insets(15));
                card.setPrefWidth(200);
                card.setPrefHeight(100);
                card.setAlignment(Pos.CENTER_LEFT);
                card.setSpacing(10);

                card.setStyle(
                                "-fx-background-color: linear-gradient(to bottom right, " + color + ", derive(" + color
                                                + ", 30%));" +
                                                "-fx-padding: 10px;" +
                                                "-fx-border-radius: 15px;" +
                                                "-fx-background-radius: 15px;" +
                                                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 12, 0, 4, 4);" +
                                                "-fx-cursor: hand;");

                card.setOnMouseEntered(e -> {
                        card.setScaleX(1.05);
                        card.setScaleY(1.05);
                });
                card.setOnMouseExited(e -> {
                        card.setScaleX(1);
                        card.setScaleY(1);
                });

                ImageView icon;
                try {
                        icon = new ImageView(new Image(
                                        "file:C:\\Users\\Issa\\Documents\\IntellijProjects\\STIMS\\src\\main\\resources\\assets\\"
                                                        + iconPath));
                } catch (Exception e) {
                        icon = new ImageView();
                }
                icon.setFitWidth(30);
                icon.setFitHeight(30);

                Label cardTitleLabel = new Label(title);
                cardTitleLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                Label valueLabel = new Label(value);
                valueLabel.setStyle("-fx-text-fill: white; -fx-font-size: 22px; -fx-font-weight: bold;");

                VBox titleBox = new VBox(cardTitleLabel);
                titleBox.setAlignment(Pos.TOP_LEFT);
                titleBox.setPrefHeight(40);

                VBox valueBox = new VBox(valueLabel);
                valueBox.setAlignment(Pos.BOTTOM_LEFT);
                valueBox.setPrefHeight(40);

                card.getChildren().addAll(icon, titleBox, valueBox);

                return card;
        }

        private Button createStyledButton(String text, String iconPath) {
                Button button = new Button(text);
                button.setPrefWidth(180);
                button.setStyle(
                                // "-fx-background-color: linear-gradient(#5A9BD5, #3B6EA5);"
                                "-fx-background-color: #4682B4; "
                                                + "-fx-text-fill: white; "
                                                + "-fx-font-weight: bold; "
                                                + "-fx-font-size: 13px;"
                                                + "-fx-padding: 10px 20px;"
                                                + "-fx-border-radius: 10px;"
                                                + "-fx-background-radius: 10px; "
                                                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 2, 2); "
                                                + "-fx-cursor: hand; ");
                try {
                        ImageView icon = new ImageView(new Image(
                                        "file:C:\\Users\\Issa\\Documents\\IntellijProjects\\STIMS\\src\\main\\resources\\assets\\"
                                                        + iconPath));
                        icon.setFitHeight(16);
                        icon.setFitWidth(16);
                        button.setGraphic(icon);
                        button.setContentDisplay(ContentDisplay.LEFT);
                } catch (Exception e) {
                        System.out.println("Missing icon: " + iconPath);
                }
                return button;
        }

}