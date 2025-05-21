package com.example.showborderpane.sims.Controllers.CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.showborderpane.sims.Main;
import com.example.showborderpane.sims.Database.DBHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Delete {
    private Button backButton;
    final String selectedLanguage = Main.getLanguage();

    private Stage studentStage;
    private Scene mainScene;

    public Delete(Stage sStage, Scene scene) {
        studentStage = sStage;
        mainScene = scene;
        deleteStd();
    }

    public static void removeStds(Stage sStage, Scene scene) {
        new Delete(sStage, scene);
    }

    private void deleteStd() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label idLabel = new Label(
                "Please enter the ID of the student to delete.\nIf you wish to delete multiple students, please input the ID separated by a comma.\nPlease do not use spaces.");
        idLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        idLabel.setAlignment(Pos.TOP_LEFT);

        TextField idField = new TextField();
        idField.setPromptText("e.g., 101,102,103");
        idField.setMaxWidth(200);

        HBox idFieldContainer = new HBox(idField);
        idFieldContainer.setAlignment(Pos.CENTER);

        Button deleteButton = new Button(selectedLanguage.equals("English") ? "Delete" : "حذف");
        deleteButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;");
        deleteButton.setOnMouseEntered(e -> deleteButton.setStyle(
                "-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        deleteButton.setOnMouseExited(e -> deleteButton.setStyle(
                "-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        Label statusLabel = new Label();
        statusLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        layout.getChildren().add(statusLabel);

        deleteButton.setOnAction(e -> {
            String input = idField.getText().trim();

            if (input.isEmpty()) {
                statusLabel.setText(selectedLanguage.equals("English") ? "Please enter at least one ID."
                        : "يرجى إدخال رقم أو أكثر.");
                statusLabel.setTextFill(Color.RED);
            } else {
                String[] ids = input.split(",");
                int totalDeleted = 0;

                for (String id : ids) {
                    String trimmedId = id.trim();
                    if (!trimmedId.isEmpty()) {
                        String sql = "DELETE FROM students WHERE std_unified_nb = ?";
                        int rowsAffected = DBHandler.executeDelete(sql, trimmedId);
                        totalDeleted += rowsAffected;
                    }
                }

                if (totalDeleted > 0) {
                    resetAutoInc();

                    statusLabel.setText((ids.length == 1
                            ? (selectedLanguage.equals("English")
                                    ? "Student deleted successfully!"
                                    : "تم حذف الطالب بنجاح!")
                            : (selectedLanguage.equals("English")
                                    ? "Students deleted successfully!"
                                    : "تم حذف الطلاب بنجاح!")));
                    statusLabel.setTextFill(Color.GREEN);

                } else {
                    statusLabel.setText(selectedLanguage.equals("English")
                            ? "No student(s) deleted. Please check the ID(s) and try again."
                            : "لم يتم حذف أي طالب. يرجى التحقق من الرقم أو الأرقام.");
                    statusLabel.setTextFill(Color.RED);
                }
            }

        });

        backButton = new Button(selectedLanguage.equals("English") ? "Back" : "العودة");
        backButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;");

        backButton.setOnMouseEntered(
                e -> backButton.setStyle(
                        "-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 14px; "
                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        backButton.setOnMouseExited(
                e -> backButton.setStyle(
                        "-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        backButton.setOnAction(e -> {
            studentStage.setScene(mainScene);
            studentStage.setHeight(500);
            studentStage.setWidth(950);
        });

        layout.getChildren().addAll(
                idLabel,
                idFieldContainer,
                new HBox(20, deleteButton, backButton) {
                    {
                        setAlignment(Pos.CENTER);
                    }
                });
        layout.setSpacing(20);

        studentStage.setScene(new Scene(layout, 300, 150));
        layout.setBackground(
                new Background(new BackgroundFill(
                        Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5),
                        null, Insets.EMPTY)));

        if (selectedLanguage.equals("English")) {

        } else if (selectedLanguage.equals("Arabic")) {
            idLabel.setText(" إدخل رقم ID الطالب المراد حذفه:");
            idField.setPromptText("رقم ID الطالب");
        }
    }

    private void resetAutoInc() {
        String resetSQL = "SELECT MAX(std_unified_nb) FROM students";
        ResultSet rs = DBHandler.executeQuery(resetSQL);
        try {
            if (rs.next()) {
                int maxId = rs.getInt(1);
                String resetAutoIncSQL = "ALTER TABLE students AUTO_INCREMENT = " + (maxId + 1);
                DBHandler.executeDelete(resetAutoIncSQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
