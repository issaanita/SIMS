package com.example.showborderpane.sims.Controllers.CRUD;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.showborderpane.sims.Main;
import com.example.showborderpane.sims.Database.DBHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Display {

    private Button backButton;
    final String selectedLanguage = Main.getLanguage();

    private Stage studentStage;
    private Scene mainScene;

    public Display(Stage sStage, Scene scene) {
        studentStage = sStage;
        mainScene = scene;
        getAllStds();
    }

    public static void displayStds(Stage sStage, Scene scene) {
        new Display(sStage, scene);
    }

    private void getAllStds() {
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);

        VBox studentContainer = new VBox(10);
        studentContainer.setPadding(new Insets(10));

        backButton = new Button(selectedLanguage.equals("English") ? "Back" : "العودة");
        backButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px;"
                + "-fx-padding: 8px 20px;");

        backButton.setOnMouseEntered(
                e -> backButton.setStyle("-fx-background-color: #5A9BD3; -fx-text-fill: white;"
                        + "-fx-font-size: 14px;-fx-font-weight: bold; -fx-border-radius: 10px;"
                        + "-fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        backButton.setOnMouseExited(
                e -> backButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;"
                        + "-fx-font-size: 14px;-fx-font-weight: bold; -fx-border-radius: 10px;"
                        + "-fx-background-radius: 10px; -fx-padding: 8px 20px;"));

        backButton.setOnAction(e -> {
            studentStage.setScene(mainScene);
            studentStage.setHeight(500);
            studentStage.setWidth(950);
        });

        String sql = "SELECT * FROM students";
        ResultSet resultSet = DBHandler.executeQuery(sql);

        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    int studentId = resultSet.getInt("std_unified_nb");
                    String fullName = resultSet.getString("first_name") + " "
                            + resultSet.getString("father_name");

                    String firstName = resultSet.getString("first_name");
                    String fatherName = resultSet.getString("father_name");
                    String motherName = resultSet.getString("mother_name");
                    Date dob = resultSet.getDate("date_of_birth");
                    String gender = resultSet.getString("gender");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("student_phone_number");
                    String parentPhone = resultSet.getString("parent_phone_number");
                    String nationality = resultSet.getString("nationality");
                    String studentType = resultSet.getString("student_type");
                    Date firstEnrollmentDate = resultSet.getDate("first_enrollment_date");
                    Date registrationDate = resultSet.getDate("registration_date");
                    String disability = resultSet.getString("disability");
                    boolean graduate = resultSet.getBoolean("graduate");
                    int classGrade = resultSet.getInt("class_grade");
                    String teacherName = resultSet.getString("teacher_name");
                    String reports = resultSet.getString("reports");

                    Label studentLabel = new Label("ID: " + studentId + " | Name: " + fullName);
                    studentLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

                    Button moreDetailsButton = new Button("More Details");
                    moreDetailsButton.setStyle(
                            "-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 12px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
                    moreDetailsButton.setOnAction(
                            e -> stdsDetails(studentId, firstName, fatherName, motherName,
                                    dob, gender, email, phoneNumber, parentPhone,
                                    nationality, studentType, firstEnrollmentDate,
                                    registrationDate, disability, graduate,
                                    classGrade, teacherName, reports));

                    Button finRecordButton = new Button("Fin Record");
                    finRecordButton.setStyle(
                            "-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 12px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
                    finRecordButton.setOnAction(e -> finDetails(studentId));

                    HBox studentRow = new HBox(10, studentLabel, moreDetailsButton,
                            finRecordButton);
                    studentRow.setAlignment(Pos.CENTER_LEFT);

                    studentContainer.getChildren().add(studentRow);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        scrollPane.setContent(studentContainer);
        layout.getChildren().addAll(scrollPane, backButton);
        studentStage.setScene(new Scene(layout, 600, 500));
        layout.setBackground(
                new Background(new BackgroundFill(
                        Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5), null, Insets.EMPTY)));

        if (selectedLanguage.equals("English")) {
            backButton.setText("Back");
        } else if (selectedLanguage.equals("Arabic")) {
            backButton.setText("العودة");
        }
    }

    private void stdsDetails(int studentId, String firstName, String fatherName, String motherName, Date dob,
            String gender, String email, String phoneNumber, String parentPhone, String nationality,
            String studentType,
            Date firstEnrollmentDate, Date registrationDate, String disability, boolean graduate,
            int classGrade,
            String teacherName, String reports) {

        String studentInfo = "Student's ID: " + studentId + "\n"
                + "First Name: " + firstName + "\n"
                + "Father's Name: " + fatherName + "\n"
                + "Mother's Name: " + motherName + "\n"
                + "Date of Birth: " + dob + "\n"
                + "Gender: " + gender + "\n"
                + "Email: " + email + "\n"
                + "Phone Number: " + phoneNumber + "\n"
                + "Parent Phone: " + parentPhone + "\n"
                + "Nationality: " + nationality + "\n"
                + "Student Type: " + studentType + "\n"
                + "First Enrollment Date: " + firstEnrollmentDate + "\n"
                + "Registration Date: " + registrationDate + "\n"
                + "Disability: " + disability + "\n"
                + "Graduate: " + graduate + "\n"
                + "Class Grade: " + classGrade + "\n"
                + "Teacher Name: " + teacherName + "\n"
                + "Reports: " + reports;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Student Details");
        alert.setHeaderText(firstName + " " + fatherName + "\n" + studentId);
        alert.setContentText(studentInfo);
        alert.showAndWait();
    }

    private void finDetails(int studentId) {
        String sql = "SELECT * FROM students WHERE std_unified_nb = ?";
        try (PreparedStatement statement = DBHandler.getConnection().prepareStatement(sql)) {
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String financialInfo = "Finacial Information for the student: "
                        + resultSet.getInt("std_unified_nb") + "\n"
                        + "Transportation Fee: " + resultSet.getBigDecimal("transportation_fee")
                        + "\n"
                        + "Sibling Discount: " + resultSet.getBigDecimal("sibling_discount")
                        + "\n"
                        + "Due Date: " + resultSet.getDate("due_date") + "\n"
                        + "Penalty Fee: " + resultSet.getBigDecimal("penalty_fee") + "\n"
                        + "Payment Method: " + resultSet.getString("payment_method") + "\n"
                        + "Date Paid: " + resultSet.getDate("date_paid");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Financial Details");
                alert.setHeaderText(("Financial Record for the Student:\n")
                        + resultSet.getString("first_name") + " "
                        + resultSet.getString("father_name") + "\n"
                        + resultSet.getInt("std_unified_nb"));
                alert.setContentText(financialInfo);
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
