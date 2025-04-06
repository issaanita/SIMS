package com.example.showborderpane.sims;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Student {
    private Stage studentStage;
    private Scene mainScene;
    private Label titleLabel;
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
    Button showAllStdBtn;
    Button addStudentBtn;
    Button editStudentBtn;
    Button deleteStudentBtn;
    Button searchStudentBtn;
    Button reportsBtn;
    GridPane dashboardGrid;
    int totalClasses = DBHandler.getCountFromDatabase("SELECT COUNT(*) FROM class;");
    int totalStudents = DBHandler.getCountFromDatabase("SELECT COUNT(*) FROM students;");
    int totalProbation = DBHandler
            .getCountFromDatabase("SELECT COUNT(*) FROM grades WHERE grade < 60;");
    int totalPenalties = DBHandler
            .getCountFromDatabase("SELECT COUNT(*) FROM students WHERE due_date < CURDATE();");

    public Student(Stage pStage) {
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

        showAllStdBtn = new Button();
        addStudentBtn = new Button();
        editStudentBtn = new Button();
        deleteStudentBtn = new Button();
        searchStudentBtn = new Button();
        reportsBtn = new Button();

        Button mainMenuBtn = new Button();
        mainMenuBtn = createStyledButton("", "home.png");
        mainMenuBtn.setOnAction(e -> {
            studentStage.close();
            Main.goToMainUI(pStage);
        });

        showAllStdBtn = createStyledButton("", "students.png");
        addStudentBtn = createStyledButton("", "addStd.png");
        editStudentBtn = createStyledButton("", "editStd.png");
        deleteStudentBtn = createStyledButton("", "deleteStd.png");
        searchStudentBtn = createStyledButton("", "search.png");
        reportsBtn = createStyledButton("", "report.png");

        showAllStdBtn.setOnAction(e -> getAllStds());
        addStudentBtn.setOnAction(e -> addStd());
        editStudentBtn.setOnAction(e -> editStd());
        deleteStudentBtn.setOnAction(e -> deleteStd());
        searchStudentBtn.setOnAction(e -> searchStd());

        buttonGrid.add(showAllStdBtn, 0, 0);
        buttonGrid.add(addStudentBtn, 1, 0);
        buttonGrid.add(editStudentBtn, 0, 1);
        buttonGrid.add(deleteStudentBtn, 1, 1);
        buttonGrid.add(searchStudentBtn, 0, 2);
        buttonGrid.add(reportsBtn, 1, 2);
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

        if (selectedLanguage.equals("English")) {
            titleLabel.setText("Student Dashboard");

            dashboardGrid.add(createDashboardCard("Total Classes", String.valueOf(totalClasses),
                    "Teal", "calendar.png"),
                    0, 0);
            dashboardGrid.add(createDashboardCard("Total Students", String.valueOf(totalStudents),
                    "Teal", "students.png"), 0, 1);

            dashboardGrid.add(buttonGrid, 1, 0, 1, 2);

            dashboardGrid.add(createDashboardCard("Total Stds Under Probation",
                    String.valueOf(totalProbation), "IndianRed", "warning.png"), 2, 0);
            dashboardGrid.add(createDashboardCard("Total Penalties", String.valueOf(totalPenalties),
                    "IndianRed", "penalty.png"), 2, 1);

            showAllStdBtn.setText("Show All Students");
            addStudentBtn.setText("Add Student");
            editStudentBtn.setText("Edit Student Info");
            deleteStudentBtn.setText("Delete Student");
            searchStudentBtn.setText("Search Student");
            reportsBtn.setText("Reports");

            mainMenuBtn.setText("Main Menu");

        } else if (selectedLanguage.equals("Arabic")) {
            titleLabel.setText("معلومات الطلاب");

            dashboardGrid.add(createDashboardCard("مجموع الصفوف", String.valueOf(totalClasses),
                    "Teal", "calendar.png"), 0, 0);
            dashboardGrid.add(createDashboardCard("مجموع الطلاب", String.valueOf(totalStudents),
                    "Teal", "students.png"), 0,
                    1);

            dashboardGrid.add(buttonGrid, 1, 0, 1, 2);

            dashboardGrid.add(createDashboardCard("مجموع الطلاب تحت المراقبة",
                    String.valueOf(totalProbation), "IndianRed", "warning.png"), 2, 0);
            dashboardGrid.add(createDashboardCard("مجموع العقوبات", String.valueOf(totalPenalties),
                    "IndianRed", "penalty.png"), 2, 1);

            showAllStdBtn.setText("عرض جميع الطلاب");
            addStudentBtn.setText("إضافة طالب");
            editStudentBtn.setText("تعديل معلومات الطالب");
            deleteStudentBtn.setText("حذف طالب");
            searchStudentBtn.setText("ابحث عن طالب");
            reportsBtn.setText("تقارير");

            mainMenuBtn.setText("القائمة الرئيسية");
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

        card.setOnMouseEntered(e -> card.setScaleX(1.05));
        card.setOnMouseEntered(e -> card.setScaleY(1.05));
        card.setOnMouseExited(e -> card.setScaleX(1));
        card.setOnMouseExited(e -> card.setScaleY(1));

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

        disabilityComboBox.setPromptText("Disability");

        Label classGradeLabel = new Label("Class Grade:");
        classGradeLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        ComboBox<Integer> classGradeComboBox = new ComboBox<>();
        classGradeComboBox.getItems().addAll(1, 2, 3, 4, 5);
        classGradeComboBox.setPromptText("Class Grade");

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

            String sql = "INSERT INTO students (first_name, last_name, father_name, mother_name, " +
                    "date_of_birth, gender, email, student_phone_number, parent_phone_number, nationality, address, "
                    +
                    "student_type, graduate, disability, class_grade, registration_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE)";

            DBHandler.executeUpdate(sql,
                    firstNameField.getText(),
                    lastNameField.getText(),
                    fatherNameField.getText(),
                    motherNameField.getText(),
                    dobPicker.getValue() != null ? java.sql.Date.valueOf(dobPicker.getValue())
                            : null,
                    genderGroup.getSelectedToggle() == maleRadio ? "Male" : "Female",
                    emailField.getText(),
                    phoneField.getText(),
                    parentPhoneField.getText(),
                    nationality,
                    addressField.getText(),
                    studentType,
                    graduateStatus,
                    disability,
                    classGradeComboBox.getValue());

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

    private void errorMsg(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("There are issues with the form:");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void editStd() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        Label idLabel = new Label("Please enter the ID of the student to edit:");
        idLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        idLabel.setAlignment(Pos.CENTER);

        TextField idField = new TextField();
        idField.setPromptText("Student ID");
        idField.setMaxWidth(200);

        TextField emailField = new TextField();
        emailField.setPromptText("New Email");

        Button submitButton = new Button("Update");

        submitButton.setOnAction(e -> {
            String sql = "UPDATE students SET email = ? WHERE std_unfied_nb = ?";
            DBHandler.executeUpdate(sql, emailField.getText(), idField.getText());
            studentStage.setScene(mainScene);
        });

        backButton = new Button(selectedLanguage.equals("English") ? "Back" : "العودة");
        backButton.setOnAction(e -> {
            studentStage.setScene(mainScene);
            studentStage.setHeight(500);
            studentStage.setWidth(950);
        });

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

        layout.getChildren().addAll(idField, idLabel, emailField, submitButton, backButton);
        studentStage.setScene(new Scene(layout, 300, 200));
        layout.setBackground(
                new Background(new BackgroundFill(
                        Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5), null, Insets.EMPTY)));

        if (selectedLanguage.equals("English")) {

        } else if (selectedLanguage.equals("Arabic")) {

        }
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
                        int rowsAffected = DBHandler.executeUpdate(sql, trimmedId);
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
                DBHandler.executeUpdate(resetAutoIncSQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchStd() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        TextField nameField = new TextField();
        nameField.setPromptText("Search by Name");

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        Button searchButton = new Button("Search");

        searchButton.setOnAction(e -> {
            String sql = "SELECT * FROM students WHERE name LIKE ?";
            ResultSet resultSet = DBHandler.executeQuery(sql, "%" + nameField.getText() + "%");
            try {
                StringBuilder result = new StringBuilder();
                while (resultSet.next()) {
                    result.append("Unified ID: ").append(resultSet.getInt("std_unified_nb"))
                            .append("\n")
                            .append("First Name: ")
                            .append(resultSet.getString("first_name")).append("\n")
                            .append("Last Name: ").append(resultSet.getString("last_name"))
                            .append("\n")
                            .append("Father's Name: ")
                            .append(resultSet.getString("father_name")).append("\n")
                            .append("Mother's Name: ")
                            .append(resultSet.getString("mother_name")).append("\n")
                            .append("Date of Birth: ")
                            .append(resultSet.getDate("date_of_birth")).append("\n")
                            .append("Gender: ").append(resultSet.getString("gender"))
                            .append("\n")
                            .append("Email: ").append(resultSet.getString("email"))
                            .append("\n")
                            .append("Phone Number: ")
                            .append(resultSet.getString("student_phone_number"))
                            .append("\n")
                            .append("Parent Phone Number: ")
                            .append(resultSet.getString("parent_phone_number"))
                            .append("\n")
                            .append("Nationality: ")
                            .append(resultSet.getString("nationality")).append("\n")
                            .append("Student Type: ")
                            .append(resultSet.getString("student_type")).append("\n")
                            .append("First Enrollment Date: ")
                            .append(resultSet.getDate("first_enrollment_date"))
                            .append("\n")
                            .append("Registration Date: ")
                            .append(resultSet.getDate("registration_date")).append("\n")
                            .append("Disability: ")
                            .append(resultSet.getString("disability")).append("\n")
                            .append("Graduate: ").append(resultSet.getBoolean("graduate"))
                            .append("\n")
                            .append("Class Grade: ").append(resultSet.getInt("class_grade"))
                            .append("\n")
                            .append("Teacher Name: ")
                            .append(resultSet.getInt("teacher_name")).append("\n")
                            .append("Reports: ").append(resultSet.getString("reports"))
                            .append("\n")
                            .append("Tuition Fee: ")
                            .append(resultSet.getBigDecimal("tuition_fee")).append("\n")
                            .append("Transportation Fee: ")
                            .append(resultSet.getBigDecimal("transportation_fee"))
                            .append("\n")
                            .append("Sibling Discount: ")
                            .append(resultSet.getBigDecimal("sibling_discount"))
                            .append("\n")
                            .append("Due Date: ").append(resultSet.getDate("due_date"))
                            .append("\n")
                            .append("Penalty Fee: ")
                            .append(resultSet.getBigDecimal("penalty_fee")).append("\n")
                            .append("Payment Method: ")
                            .append(resultSet.getString("payment_method")).append("\n")
                            .append("Date Paid: ").append(resultSet.getDate("date_paid"))
                            .append("\n\n");
                }
                resultArea.setText(result.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
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

        layout.getChildren().addAll(nameField, searchButton, resultArea, backButton);
        studentStage.setScene(new Scene(layout, 350, 200));
        layout.setBackground(
                new Background(new BackgroundFill(
                        Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5), null, Insets.EMPTY)));

        if (selectedLanguage.equals("English")) {

        } else if (selectedLanguage.equals("Arabic")) {

        }
    }
}