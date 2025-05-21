package com.example.showborderpane.sims.Controllers.CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.showborderpane.sims.Main;
import com.example.showborderpane.sims.Database.DBHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class Search {
    private Button backButton;
    final String selectedLanguage = Main.getLanguage();

    private Stage studentStage;
    private Scene mainScene;

    public Search(Stage sStage, Scene scene) {
        studentStage = sStage;
        mainScene = scene;
        searchStd();
    }

    public static void findStd(Stage sStage, Scene scene) {
        new Search(sStage, scene);
    }

    private void searchStd() {

        CheckBox idCheckBox = new CheckBox("Search by ID");
        CheckBox firstNameCheckBox = new CheckBox("Search by First Name");
        CheckBox phoneNumberCheckBox = new CheckBox("Search by Phone Number");

        TextField idField = new TextField();
        idField.setPromptText("Enter ID");
        idField.setVisible(false);
        idField.setPrefWidth(200);
        idField.setMaxWidth(200);

        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter First Name");
        firstNameField.setVisible(false);
        firstNameField.setPrefWidth(200);
        firstNameField.setMaxWidth(200);

        TextField phoneNumberField = new TextField();
        phoneNumberField.setPromptText("Enter Phone Number");
        phoneNumberField.setVisible(false);
        phoneNumberField.setPrefWidth(200);
        phoneNumberField.setMaxWidth(200);

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setVisible(false);
        resultArea.setPrefWidth(200);
        resultArea.setMaxWidth(200);
        resultArea.setPrefHeight(175);
        resultArea.setMaxHeight(175);

        idCheckBox.setOnAction(e -> idField.setVisible(idCheckBox.isSelected()));
        firstNameCheckBox.setOnAction(e -> firstNameField.setVisible(firstNameCheckBox.isSelected()));
        phoneNumberCheckBox.setOnAction(e -> phoneNumberField.setVisible(phoneNumberCheckBox.isSelected()));

        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;");

        searchButton.setOnMouseEntered(e -> searchButton.setStyle(
                "-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        searchButton.setOnMouseExited(e -> searchButton.setStyle(
                "-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));

        searchButton.setOnAction(e -> {
            StringBuilder sql = new StringBuilder("SELECT * FROM students WHERE 1=1");
            boolean hasCriteria = false;

            if (idCheckBox.isSelected() && !idField.getText().trim().isEmpty()) {
                sql.append(" AND std_unified_nb = ").append(idField.getText().trim());
                hasCriteria = true;
            }

            if (firstNameCheckBox.isSelected() && !firstNameField.getText().trim().isEmpty()) {
                sql.append(" AND first_name LIKE '%").append(firstNameField.getText().trim()).append("%'");
                hasCriteria = true;
            }

            if (phoneNumberCheckBox.isSelected() && !phoneNumberField.getText().trim().isEmpty()) {
                sql.append(" AND student_phone_number LIKE '%").append(phoneNumberField.getText().trim()).append("%'");
                hasCriteria = true;
            }

            if (!hasCriteria) {
                resultArea.setText("Please select and fill at least one search parameter.");
                return;
            }

            ResultSet resultSet = DBHandler.executeQuery(sql.toString());
            try {
                StringBuilder result = new StringBuilder();
                while (resultSet.next()) {
                    result.append("Unified ID: ").append(resultSet.getInt("std_unified_nb")).append("\n")
                            .append("First Name: ").append(resultSet.getString("first_name")).append("\n")
                            .append("Last Name: ").append(resultSet.getString("last_name")).append("\n")
                            .append("Phone Number: ").append(resultSet.getString("student_phone_number")).append("\n")
                            .append("Email: ").append(resultSet.getString("email")).append("\n")
                            .append("Class Grade: ").append(resultSet.getInt("class_grade")).append("\n\n");
                }
                resultArea.setText(result.toString().isEmpty() ? "No matching students found." : result.toString());
                resultArea.setVisible(true);
            } catch (SQLException ex) {
                resultArea.setText("An error occurred while fetching results.");
                ex.printStackTrace();
            }
        });

        backButton = new Button(selectedLanguage.equals("English") ? "Back" : "العودة");
        backButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;");
        backButton.setOnMouseEntered(e -> backButton.setStyle(
                "-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        backButton.setOnMouseExited(e -> backButton.setStyle(
                "-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        backButton.setOnAction(e -> {
            studentStage.setScene(mainScene);
            studentStage.setHeight(500);
            studentStage.setWidth(950);
        });
        VBox inputControls = new VBox(10);
        inputControls.getChildren().addAll(
                idCheckBox, idField,
                firstNameCheckBox, firstNameField,
                phoneNumberCheckBox, phoneNumberField,
                searchButton);

        VBox resultControls = new VBox(10);
        resultArea.setPrefSize(300, 300);
        resultControls.getChildren().addAll(resultArea, backButton);

        HBox mainLayout = new HBox(20);
        mainLayout.setAlignment(Pos.BOTTOM_CENTER);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(inputControls, resultControls);
        mainLayout.setBackground(new Background(new BackgroundFill(
                Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5), null, Insets.EMPTY)));
        StackPane root = new StackPane(mainLayout);
        root.setAlignment(Pos.CENTER);

        studentStage.setScene(new Scene(root, 700, 500));
    }

}
