package com.example.showborderpane.sims.Controllers.CRUD;

import com.example.showborderpane.sims.Main;
import com.example.showborderpane.sims.Database.DBHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Edit {

        private Button backButton;
        private Button updateButton;

        final String selectedLanguage = Main.getLanguage();

        private Stage studentStage;
        private Scene mainScene;

        public Edit(Stage sStage, Scene scene) {
                studentStage = sStage;
                mainScene = scene;
                editStd();
        }

        public static void updateStd(Stage sStage, Scene scene) {
                new Edit(sStage, scene);
        }

        private void editStd() {
                VBox layout = new VBox(10);
                layout.setPadding(new Insets(10));
                layout.setAlignment(Pos.CENTER);

                ComboBox<String> editOptionCombo = new ComboBox<>();
                editOptionCombo.getItems().addAll("Edit Personal Info", "Edit Financial Info");
                editOptionCombo.setValue("Edit Personal Info");
                editOptionCombo.setMaxWidth(200);

                Label idLabel = new Label("Please enter the ID of the student to edit:");
                idLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
                idLabel.setAlignment(Pos.CENTER);

                TextField idField = new TextField();
                idField.setPromptText("Student ID");
                idField.setMaxWidth(200);

                // Personal Info Fields
                Label firstNameLabel = new Label("First Name:");
                TextField firstNameField = new TextField();
                firstNameField.setPromptText("First Name");
                firstNameField.setMaxWidth(200);

                Label lastNameLabel = new Label("Last Name:");
                TextField lastNameField = new TextField();
                lastNameField.setPromptText("Last Name");
                lastNameField.setMaxWidth(200);

                Label fatherNameLabel = new Label("Father's Name:");
                TextField fatherNameField = new TextField();
                fatherNameField.setPromptText("Father's Name");
                fatherNameField.setMaxWidth(200);

                Label motherNameLabel = new Label("Mother's Name:");
                TextField motherNameField = new TextField();
                motherNameField.setPromptText("Mother's Name");
                motherNameField.setMaxWidth(200);

                Label dobLabel = new Label("Date of Birth (DD/MM/YYYY):");
                TextField dobField = new TextField();
                dobField.setPromptText("DD/MM/YYYY");
                dobField.setMaxWidth(200);

                Label genderLabel = new Label("Gender:");
                ComboBox<String> genderComboBox = new ComboBox<>();
                genderComboBox.getItems().addAll("Male", "Female", "Other");
                genderComboBox.setValue("Male");
                genderComboBox.setMaxWidth(200);

                Label emailLabel = new Label("Email Address:");
                TextField emailField = new TextField();
                emailField.setPromptText("Email Address");
                emailField.setMaxWidth(200);

                Label phoneLabel = new Label("Student Phone Number:");
                TextField phoneField = new TextField();
                phoneField.setPromptText("Phone Number");
                phoneField.setMaxWidth(200);

                Label parentPhoneLabel = new Label("Parent Phone Number:");
                TextField parentPhoneField = new TextField();
                parentPhoneField.setPromptText("Parent Phone Number");
                parentPhoneField.setMaxWidth(200);

                Label nationalityLabel = new Label("Nationality:");
                ToggleGroup nationalityGroup = new ToggleGroup();
                RadioButton lebaneseRadio = new RadioButton("Lebanese");
                lebaneseRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

                lebaneseRadio.setToggleGroup(nationalityGroup);
                RadioButton nonLebaneseRadio = new RadioButton("Other");
                nonLebaneseRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

                nonLebaneseRadio.setToggleGroup(nationalityGroup);

                ComboBox<String> nationalityComboBox = new ComboBox<>();
                nationalityComboBox.getItems().addAll("American", "French", "Syrian", "Egyptian", "Jordanian");
                nationalityComboBox.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

                nationalityComboBox.setVisible(false);
                nationalityComboBox.setMaxWidth(200);

                lebaneseRadio.setOnAction(e -> nationalityComboBox.setVisible(false));
                nonLebaneseRadio.setOnAction(e -> nationalityComboBox.setVisible(true));

                // Financial Info Fields
                Label tuitionLabel = new Label("Tuition Fee:");
                TextField tuitionField = new TextField();
                tuitionField.setPromptText("Tuition Fee");
                tuitionField.setMaxWidth(200);

                Label transportationFeeLabel = new Label("Transportation Fee:");
                TextField transportationFeeField = new TextField();
                transportationFeeField.setPromptText("Transportation Fee");
                transportationFeeField.setMaxWidth(200);

                Label siblingDiscountLabel = new Label("Sibling Discount:");
                TextField siblingDiscountField = new TextField();
                siblingDiscountField.setPromptText("Sibling Discount");
                siblingDiscountField.setMaxWidth(200);

                Label penaltyFeeLabel = new Label("Penalty Fee:");
                TextField penaltyFeeField = new TextField();
                penaltyFeeField.setPromptText("Penalty Fee");
                penaltyFeeField.setMaxWidth(200);

                Label paymentMethodLabel = new Label("Payment Method:");
                ComboBox<String> paymentMethodComboBox = new ComboBox<>();
                paymentMethodComboBox.getItems().addAll("At the School", "At the Bank");
                paymentMethodComboBox.setMaxWidth(200);

                Label datePaidLabel = new Label("Date Paid");
                DatePicker datePaid = new DatePicker();
                datePaid.setPromptText("DD/MM/YYYY");

                updateButton = new Button("Update");

                updateButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;");

                updateButton.setOnMouseEntered(
                                e -> updateButton.setStyle(
                                                "-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 14px; "
                                                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
                updateButton.setOnMouseExited(
                                e -> updateButton.setStyle(
                                                "-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                                                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));

                editOptionCombo.setOnAction(e -> {
                        if (editOptionCombo.getValue().equals("Edit Personal Info")) {
                                layout.getChildren().clear();
                                layout.getChildren().addAll(editOptionCombo, idLabel, idField, firstNameLabel,
                                                firstNameField,
                                                lastNameLabel, lastNameField, fatherNameLabel, fatherNameField,
                                                motherNameLabel,
                                                motherNameField,
                                                dobLabel, dobField, genderLabel, genderComboBox, emailLabel, emailField,
                                                phoneLabel, phoneField,
                                                parentPhoneLabel, parentPhoneField, nationalityLabel, lebaneseRadio,
                                                nonLebaneseRadio,
                                                nationalityComboBox,
                                                updateButton,
                                                backButton);
                        } else {
                                layout.getChildren().clear();
                                layout.getChildren().addAll(editOptionCombo, idLabel, idField, tuitionLabel,
                                                tuitionField,
                                                transportationFeeLabel, transportationFeeField, siblingDiscountLabel,
                                                siblingDiscountField,
                                                penaltyFeeLabel, penaltyFeeField, paymentMethodLabel,
                                                paymentMethodComboBox, datePaidLabel,
                                                datePaid,
                                                updateButton, backButton);
                        }
                });

                updateButton.setOnAction(e -> {
                        String id = idField.getText();
                        if (id == null || id.trim().isEmpty()) {
                                System.out.println("Please enter an ID");
                                return;
                        }
                        String nationality = lebaneseRadio.isSelected() ? "Lebanese" : nationalityComboBox.getValue();
                        String Pmethod = paymentMethodComboBox.getValue();

                        if (editOptionCombo.getValue().equals("Edit Personal Info")) {

                                DBHandler.executeUpdate(
                                                "UPDATE students SET first_name = ?, last_name = ?, father_name = ?, mother_name = ?, date_of_birth = ?, gender = ?, email = ?, student_phone_number = ?, parent_phone_number = ?, nationality = ? WHERE std_unified_nb = ?",
                                                emptyToTBA(firstNameField.getText()),
                                                emptyToTBA(lastNameField.getText()),
                                                emptyToTBA(fatherNameField.getText()),
                                                emptyToTBA(motherNameField.getText()),
                                                emptyToTBA(dobField.getText()),
                                                emptyToTBA(genderComboBox.getValue()),
                                                emptyToTBA(emailField.getText()),
                                                emptyToTBA(phoneField.getText()),
                                                emptyToTBA(parentPhoneField.getText()),
                                                emptyToTBA(nationality),
                                                id);

                        } else if (editOptionCombo.getValue().equals("Edit Financial Info")) {

                                DBHandler.executeUpdate(
                                                "UPDATE students SET tuition_fee = ?, transportation_fee = ?, sibling_discount = ?, penalty_fee = ?, payment_method = ?, date_paid = ? WHERE std_unified_nb = ?",
                                                emptyToTBA(tuitionField.getText()),
                                                emptyToTBA(transportationFeeField.getText()),
                                                emptyToTBA(siblingDiscountField.getText()),
                                                emptyToTBA(penaltyFeeField.getText()),
                                                emptyToTBA(Pmethod),
                                                datePaid != null ? datePaid : java.sql.Date.valueOf("2021-01-01"),
                                                id);
                        }

                });

                backButton = new Button(selectedLanguage.equals("English") ? "Back" : "العودة");

                backButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;");

                backButton.setOnMouseEntered(e -> backButton
                                .setStyle("-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 14px; "
                                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
                backButton.setOnMouseExited(e -> backButton
                                .setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
                backButton.setOnAction(e ->

                {
                        studentStage.setScene(mainScene);
                        studentStage.setHeight(500);
                        studentStage.setWidth(950);
                });

                if (editOptionCombo != null)
                        layout.getChildren().add(editOptionCombo);
                if (idLabel != null)
                        layout.getChildren().add(idLabel);
                if (idField != null)
                        layout.getChildren().add(idField);
                if (firstNameLabel != null)
                        layout.getChildren().add(firstNameLabel);
                if (firstNameField != null)
                        layout.getChildren().add(firstNameField);
                if (lastNameLabel != null)
                        layout.getChildren().add(lastNameLabel);
                if (lastNameField != null)
                        layout.getChildren().add(lastNameField);
                if (fatherNameLabel != null)
                        layout.getChildren().add(fatherNameLabel);
                if (fatherNameField != null)
                        layout.getChildren().add(fatherNameField);
                if (motherNameLabel != null)
                        layout.getChildren().add(motherNameLabel);
                if (motherNameField != null)
                        layout.getChildren().add(motherNameField);
                if (dobLabel != null)
                        layout.getChildren().add(dobLabel);
                if (dobField != null)
                        layout.getChildren().add(dobField);
                if (genderLabel != null)
                        layout.getChildren().add(genderLabel);
                if (genderComboBox != null)
                        layout.getChildren().add(genderComboBox);
                if (emailLabel != null)
                        layout.getChildren().add(emailLabel);
                if (emailField != null)
                        layout.getChildren().add(emailField);
                if (phoneLabel != null)
                        layout.getChildren().add(phoneLabel);
                if (phoneField != null)
                        layout.getChildren().add(phoneField);
                if (parentPhoneLabel != null)
                        layout.getChildren().add(parentPhoneLabel);
                if (parentPhoneField != null)
                        layout.getChildren().add(parentPhoneField);
                if (nationalityLabel != null)
                        layout.getChildren().add(nationalityLabel);
                if (lebaneseRadio != null)
                        layout.getChildren().add(lebaneseRadio);
                if (nonLebaneseRadio != null)
                        layout.getChildren().add(nonLebaneseRadio);
                if (nationalityComboBox != null)
                        layout.getChildren().add(nationalityComboBox);
                if (updateButton != null)
                        layout.getChildren().add(updateButton);
                if (backButton != null)
                        layout.getChildren().add(backButton);

                layout.setBackground(new Background(
                                new BackgroundFill(Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5), null, Insets.EMPTY)));

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(layout);
                scrollPane.setFitToHeight(true);
                scrollPane.setFitToWidth(true);

                Scene editScene = new Scene(scrollPane, 600,
                                500);
                studentStage.setScene(editScene);
                studentStage.show();
                if (selectedLanguage.equals("English")) {

                } else if (selectedLanguage.equals("Arabic")) {

                }
        }

        /**
         * 
         * these are the methods that handle what happens when the user tries to insert
         * empty values to the database
         * I decided to handle them manually instead of making the DB full of null
         * values
         * by creating multiple overloaded instances of it for different types of data
         */

        // For Strings: replaces empty with "TBA"
        private String emptyToTBA(String input) {
                return (input == null || input.trim().isEmpty()) ? "TBA" : input;
        }

        // For Integers and Doubles: replaces empty with the numeric equivalent of "TBA"
        private Integer emptyToTBA(Integer input) {
                int tba = 2021;
                return (input == null || input.toString().trim().isEmpty()) ? tba : input;
        }

        private Double emptyToTBA(Double input) {
                double tba = 20.21;
                return (input == null || input.toString().trim().isEmpty()) ? tba : input;
        }

}