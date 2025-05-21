package com.example.showborderpane.sims.Controllers.CRUD;

import java.util.Date;

import com.example.showborderpane.sims.Main;
import com.example.showborderpane.sims.Database.DBHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Add {

    final String selectedLanguage = Main.getLanguage();

    Label firstNameLabel;
    TextField firstNameField;
    Label lastNameLabel;
    TextField lastNameField;
    Label fatherNameLabel;
    TextField fatherNameField;
    Label motherNameLabel;
    TextField motherNameField;
    Label dobLabel;
    Label genderLabel;
    RadioButton maleRadio;
    RadioButton femaleRadio;
    Label nationalityLabel;
    RadioButton lebaneseRadio;
    RadioButton nonLebaneseRadio;
    ComboBox<String> nationalityComboBox;
    Label emailLabel;
    TextField emailField;
    Label phoneLabel;
    TextField phoneField;
    Label parentPhoneLabel;
    TextField parentPhoneField;
    Label addressLabel;
    TextField addressField;
    Label studentTypeLabel;
    RadioButton newStudentRadio;
    RadioButton oldStudentRadio;
    Label newStudentTypeLabel;
    RadioButton transferStudentRadio;
    RadioButton newAdmitRadio;
    Label oldStudentTypeLabel;
    RadioButton continuingStudentRadio;
    RadioButton repeatingStudentRadio;
    RadioButton graduateStudentRadio;
    Label disabilityLabel;
    ComboBox<String> disabilityComboBox;

    Button submitButton;
    Button backButton;

    private Stage studentStage;
    private Scene mainScene;

    public Add(Stage sStage, Scene scene) {
        studentStage = sStage;
        mainScene = scene;
        addStd();
    }

    public static void getAddStd(Stage sStage, Scene scene) {
        new Add(sStage, scene);
    }

    private void addStd() {
        firstNameLabel = new Label("First Name:");
        firstNameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        firstNameField = new TextField();
        firstNameField.setPromptText("First Name");

        lastNameLabel = new Label("Last Name:");
        lastNameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        fatherNameLabel = new Label("Father's Name:");
        fatherNameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        fatherNameField = new TextField();
        fatherNameField.setPromptText("Father's Name");

        motherNameLabel = new Label("Mother's Name:");
        motherNameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        motherNameField = new TextField();
        motherNameField.setPromptText("Mother's Name");

        dobLabel = new Label("Date of Birth:");
        dobLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        DatePicker dobPicker = new DatePicker();
        dobPicker.setPromptText("Date of Birth");

        genderLabel = new Label("Gender:");
        genderLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        ToggleGroup genderGroup = new ToggleGroup();
        maleRadio = new RadioButton("Male");
        maleRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        maleRadio.setToggleGroup(genderGroup);
        femaleRadio = new RadioButton("Female");
        femaleRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        femaleRadio.setToggleGroup(genderGroup);

        nationalityLabel = new Label("Nationality:");
        nationalityLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        ToggleGroup nationalityGroup = new ToggleGroup();
        lebaneseRadio = new RadioButton("Lebanese");
        lebaneseRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        lebaneseRadio.setToggleGroup(nationalityGroup);
        nonLebaneseRadio = new RadioButton("Other");
        nonLebaneseRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        nonLebaneseRadio.setToggleGroup(nationalityGroup);

        nationalityComboBox = new ComboBox<>();
        nationalityComboBox.getItems().addAll("American", "French", "Syrian", "Egyptian", "Jordanian");
        nationalityComboBox.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        nationalityComboBox.setVisible(false);

        emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        emailField = new TextField();
        emailField.setPromptText("Email");

        phoneLabel = new Label("Phone Number:");
        phoneLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        phoneField = new TextField();
        phoneField.setPromptText("Student Phone");

        parentPhoneLabel = new Label("Parent Phone:");
        parentPhoneLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        parentPhoneField = new TextField();
        parentPhoneField.setPromptText("Parent Phone");

        addressLabel = new Label("Address:");
        addressLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        addressField = new TextField();
        addressField.setPromptText("Address");

        studentTypeLabel = new Label("Student Type:");
        studentTypeLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        ToggleGroup studentTypeGroup = new ToggleGroup();
        newStudentRadio = new RadioButton("New Student");
        newStudentRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        newStudentRadio.setToggleGroup(studentTypeGroup);
        oldStudentRadio = new RadioButton("Old Student");
        oldStudentRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        oldStudentRadio.setToggleGroup(studentTypeGroup);

        newStudentTypeLabel = new Label("New Student Type:");
        newStudentRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        ToggleGroup newStudentTypeGroup = new ToggleGroup();
        transferStudentRadio = new RadioButton("Transfer");
        transferStudentRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        transferStudentRadio.setToggleGroup(newStudentTypeGroup);

        newAdmitRadio = new RadioButton("New Admit");
        newAdmitRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        newAdmitRadio.setToggleGroup(newStudentTypeGroup);

        oldStudentTypeLabel = new Label("Old Student Type:");
        oldStudentRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        ToggleGroup oldStudentTypeGroup = new ToggleGroup();
        continuingStudentRadio = new RadioButton("Continuing");
        continuingStudentRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        continuingStudentRadio.setToggleGroup(oldStudentTypeGroup);

        repeatingStudentRadio = new RadioButton("Repeating");
        repeatingStudentRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        repeatingStudentRadio.setToggleGroup(oldStudentTypeGroup);

        graduateStudentRadio = new RadioButton("Graduate");
        graduateStudentRadio.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        graduateStudentRadio.setToggleGroup(oldStudentTypeGroup);

        disabilityLabel = new Label("Disability:");
        disabilityLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        disabilityComboBox = new ComboBox<>();
        disabilityComboBox.getItems().addAll("None", "Physical Disability", "Learning Disability",
                "Hearing Impairment",
                "Visual Impairment");

        Label classGradeLabel = new Label("Class Grade:");
        classGradeLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        ComboBox<Integer> classGradeComboBox = new ComboBox<>();
        classGradeComboBox.getItems().addAll(1, 2, 3, 4, 5);

        submitButton = new Button("Submit");

        submitButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;");

        submitButton.setOnMouseEntered(
                e -> submitButton.setStyle(
                        "-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 14px; "
                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        submitButton.setOnMouseExited(
                e -> submitButton.setStyle(
                        "-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        submitButton.setOnAction(e -> {

            StringBuilder errorMessages = new StringBuilder();

            String FirstName = firstNameField.getText().trim();
            if (FirstName.isEmpty()) {
                errorMessages.append("Student's first name must not be null.\n");
            }
            String LastName = lastNameField.getText().trim();
            if (LastName.isEmpty()) {
                errorMessages.append("Student's last name must not be null.\n");
            }
            String MotherName = motherNameField.getText().trim();
            if (MotherName.isEmpty()) {
                errorMessages.append("Student's mother name must not be null.\n");
            }
            String FatherName = fatherNameField.getText().trim();
            if (FatherName.isEmpty()) {
                errorMessages.append("Student's father's name must not be null.\n");
            }
            Date dobSql = dobPicker.getValue() != null
                    ? java.sql.Date.valueOf(dobPicker.getValue())
                    : null;

            String email = emailField.getText().trim();
            if (!email.isEmpty()
                    && !(email.contains("@example.com") || email.contains("@gmail.com")
                            || email.contains("@yahoo.com"))) {
                errorMessages.append("Invalid email format. Please enter a valid email.\n");
            }

            String phone = phoneField.getText();

            if (phone.isEmpty()) {
                errorMessages.append("Phone number must not be null.\n");
            } else if (lebaneseRadio.isSelected()) {
                if (!phone.matches("\\+961 \\d{2} \\d{3} \\d{3}")) {
                    errorMessages.append(
                            "Lebanese phone number must follow the format: +961 XX XXX XXX\n");
                }
            } else {
                if (!phone.matches("\\d+")) {
                    errorMessages.append("Phone number must contain only numbers.\n");
                }
            }

            if (errorMessages.length() > 0) {
                errorMsg(errorMessages.toString());
                return;
            }

            String nationality = lebaneseRadio.isSelected() ? "Lebanese" : nationalityComboBox.getValue();
            if (nationality.isEmpty()) {
                errorMessages.append("Nationality must not be null.\n");
            }

            int graduateStatus = graduateStudentRadio.isSelected() ? 1 : 0;

            String disability = disabilityComboBox.getValue().equals("None") ? null
                    : disabilityComboBox.getValue();

            String studentType = "";

            if (newStudentRadio.isSelected()) {
                if (transferStudentRadio.isSelected()) {
                    studentType = "Transfer Student";
                } else if (newAdmitRadio.isSelected()) {
                    studentType = "New Admit";
                }
            } else if (oldStudentRadio.isSelected()) {
                if (continuingStudentRadio.isSelected()) {
                    studentType = "Continuing Student";
                } else if (repeatingStudentRadio.isSelected()) {
                    studentType = "Repeating Student";
                } else if (graduateStudentRadio.isSelected()) {
                    studentType = "Graduate Student";
                }
            }

            String classGrade;
            if (graduateStudentRadio.isSelected()) {
                classGrade = "Grad Student";
            } else {
                classGrade = classGradeComboBox.getValue() != null ? String.valueOf(classGradeComboBox.getValue())
                        : "Grad Student";
            }
            if (!maleRadio.isSelected() && !femaleRadio.isSelected()) {
                errorMessages.append("Gender must be selected.\n");
            }
            if (!lebaneseRadio.isSelected() && !nonLebaneseRadio.isSelected()) {
                errorMessages.append("Nationality must be selected.\n");
            } else if (nonLebaneseRadio.isSelected()) {
                String selectedNationality = nationalityComboBox.getValue();
                if (selectedNationality == null || selectedNationality.trim().isEmpty()) {
                    errorMessages.append("Please select a nationality.\n");
                }
            }

            String parentPhone = parentPhoneField.getText().trim();
            if (parentPhone.isEmpty()) {
                errorMessages.append("Parent's phone number must not be null.\n");
            } else if (!parentPhone.matches("\\d+")) {
                errorMessages.append("Parent's phone number must contain only digits.\n");
            }

            String address = addressField.getText().trim();
            if (address.isEmpty()) {
                errorMessages.append("Address must not be null.\n");
            }

            String sql = "INSERT INTO students (first_name, last_name, father_name, mother_name, " +
                    "date_of_birth, gender, email, student_phone_number, parent_phone_number, nationality, address, "
                    +
                    "student_type, graduate, disability, class_grade, registration_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE)";

            DBHandler.executeUpdate(sql,
                    emptyToTBA(firstNameField.getText()),
                    emptyToTBA(lastNameField.getText()),
                    emptyToTBA(fatherNameField.getText()),
                    emptyToTBA(motherNameField.getText()),
                    dobSql != null ? dobSql : java.sql.Date.valueOf("2021-01-01"),
                    genderGroup.getSelectedToggle() == maleRadio ? "Male" : "Female",
                    emptyToTBA(emailField.getText()),
                    emptyToTBA(phoneField.getText()),
                    emptyToTBA(parentPhoneField.getText()),
                    emptyToTBA(nationality),
                    emptyToTBA(addressField.getText()),
                    emptyToTBA(studentType),
                    emptyToTBA(graduateStatus),
                    emptyToTBA(disability),
                    emptyToTBA(classGrade));

            studentStage.setScene(mainScene);
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

        lebaneseRadio.setOnAction(e -> nationalityComboBox.setVisible(false));
        nonLebaneseRadio.setOnAction(e -> nationalityComboBox.setVisible(true));

        GridPane textFieldsPane = new GridPane();
        textFieldsPane.setPadding(new Insets(0, 0, 100, 0));
        textFieldsPane.setAlignment(Pos.CENTER_LEFT);
        textFieldsPane.setVgap(10);
        textFieldsPane.setHgap(10);

        textFieldsPane.add(firstNameLabel, 0, 0);
        textFieldsPane.add(firstNameField, 1, 0);

        textFieldsPane.add(lastNameLabel, 0, 1);
        textFieldsPane.add(lastNameField, 1, 1);

        textFieldsPane.add(fatherNameLabel, 0, 2);
        textFieldsPane.add(fatherNameField, 1, 2);

        textFieldsPane.add(motherNameLabel, 0, 3);
        textFieldsPane.add(motherNameField, 1, 3);

        textFieldsPane.add(dobLabel, 0, 4);
        textFieldsPane.add(dobPicker, 1, 4);

        textFieldsPane.add(emailLabel, 0, 5);
        textFieldsPane.add(emailField, 1, 5);

        textFieldsPane.add(phoneLabel, 0, 6);
        textFieldsPane.add(phoneField, 1, 6);

        GridPane selectionPane = new GridPane();
        selectionPane.setPadding(new Insets(0, -300, 100, 50));
        selectionPane.setAlignment(Pos.CENTER_RIGHT);
        selectionPane.setVgap(10);
        selectionPane.setHgap(10);

        selectionPane.add(genderLabel, 0, 0);
        selectionPane.add(maleRadio, 1, 0);
        selectionPane.add(femaleRadio, 2, 0);

        selectionPane.add(nationalityLabel, 0, 1);
        selectionPane.add(lebaneseRadio, 1, 1);
        selectionPane.add(nonLebaneseRadio, 2, 1);
        selectionPane.add(nationalityComboBox, 1, 2, 2, 1);

        selectionPane.add(studentTypeLabel, 0, 3);
        selectionPane.add(newStudentRadio, 1, 3);
        selectionPane.add(oldStudentRadio, 2, 3);

        selectionPane.add(transferStudentRadio, 1, 4);
        selectionPane.add(newAdmitRadio, 2, 4);

        selectionPane.add(graduateStudentRadio, 0, 4);
        selectionPane.add(continuingStudentRadio, 1, 4);
        selectionPane.add(repeatingStudentRadio, 2, 4);

        selectionPane.add(disabilityLabel, 0, 5);
        selectionPane.add(disabilityComboBox, 1, 5);

        selectionPane.add(classGradeLabel, 0, 6);
        selectionPane.add(classGradeComboBox, 1, 6);

        GridPane buttonsPane = new GridPane();
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setHgap(10);

        buttonsPane.add(submitButton, 0, 0);
        buttonsPane.add(backButton, 1, 0);

        transferStudentRadio.setVisible(false);
        newAdmitRadio.setVisible(false);
        continuingStudentRadio.setVisible(false);
        repeatingStudentRadio.setVisible(false);
        graduateStudentRadio.setVisible(false);

        classGradeComboBox.setVisible(false);
        classGradeLabel.setVisible(false);

        studentTypeGroup.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {

            if (newToggle == newStudentRadio) {

                graduateStudentRadio.setSelected(false);
                continuingStudentRadio.setSelected(false);
                repeatingStudentRadio.setSelected(false);

                transferStudentRadio.setVisible(true);
                newAdmitRadio.setVisible(true);

                continuingStudentRadio.setVisible(false);
                repeatingStudentRadio.setVisible(false);

                graduateStudentRadio.setVisible(false);

                classGradeComboBox.setVisible(true);
                classGradeLabel.setVisible(true);

            } else if (newToggle == oldStudentRadio) {

                transferStudentRadio.setSelected(false);
                newAdmitRadio.setSelected(false);

                transferStudentRadio.setVisible(false);
                newAdmitRadio.setVisible(false);

                continuingStudentRadio.setVisible(true);
                repeatingStudentRadio.setVisible(true);

                graduateStudentRadio.setVisible(true);

                classGradeComboBox.setVisible(true);
                classGradeLabel.setVisible(true);
            }
        });

        graduateStudentRadio.setOnAction(e -> {
            classGradeComboBox.setVisible(false);
            classGradeLabel.setVisible(false);
        });

        continuingStudentRadio.setOnAction(e -> {
            classGradeComboBox.setVisible(true);
            classGradeLabel.setVisible(true);
        });

        repeatingStudentRadio.setOnAction(e -> {
            classGradeComboBox.setVisible(true);
            classGradeLabel.setVisible(true);
        });

        HBox mainLayout = new HBox(0);
        mainLayout.setPadding(new Insets(20));
        mainLayout.getChildren().addAll(textFieldsPane, selectionPane);

        VBox finalLayout = new VBox(0);
        finalLayout.setPadding(new Insets(20));
        finalLayout.getChildren().addAll(mainLayout, buttonsPane);
        finalLayout.setBackground(
                new Background(new BackgroundFill(
                        Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5), null, Insets.EMPTY)));

        Scene scene = new Scene(finalLayout, 800, 600);
        studentStage.setScene(scene);
        studentStage.show();

        if (selectedLanguage.equals("English")) {

        } else if (selectedLanguage.equals("Arabic")) {

        }
    }

    private String emptyToTBA(String input) {
        return (input == null || input.trim().isEmpty()) ? "TBA" : input;
    }

    private Integer emptyToTBA(Integer input) {
        int tba = 2021;
        return (input == null || input.toString().trim().isEmpty()) ? tba : input;
    }

    private Double emptyToTBA(Double input) {
        double tba = 20.21;
        return (input == null || input.toString().trim().isEmpty()) ? tba : input;
    }

    private void errorMsg(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("There are issues with the form:");
        alert.setContentText(message);
        alert.showAndWait();
    }
}