package com.example.showborderpane.sims;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Main extends Application {

    private Label welcomeLabel;
    private Label stdLabel;
    private Label infoLabel;
    private Label stimsLabel;
    private Label promptLabel;
    private Button submitButton;
    private RadioButton studentRadio;
    private RadioButton teacherRadio;
    private static ComboBox<String> language;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setResizable(false);

        showLoginUI(primaryStage);
    }

    private void showLoginUI(Stage primaryStage) {
        primaryStage.setWidth(400);
        primaryStage.setHeight(250);
        primaryStage.setX(550);
        primaryStage.setY(250);

        Label userLabel = new Label("Username:");
        userLabel.setTextFill(Color.WHITE);
        userLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        TextField userField = new TextField();
        userField.setPromptText("Enter username");
        userField.setStyle(
                "-fx-font-size: 16px; -fx-background-color: #2F4F4F; -fx-text-fill: white; -fx-border-color: #4682B4; -fx-border-width: 2px; -fx-border-radius: 5px;");
        userField.setPrefWidth(250);

        HBox userHBox = new HBox(10, userLabel, userField);
        userHBox.setAlignment(Pos.CENTER);

        Label passLabel = new Label("Password:");
        passLabel.setTextFill(Color.WHITE);
        passLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter password");
        passField.setStyle(
                "-fx-font-size: 16px; -fx-background-color: #2F4F4F; -fx-text-fill: white; -fx-border-color: #4682B4; -fx-border-width: 2px; -fx-border-radius: 5px;");
        passField.setPrefWidth(250);

        HBox passHBox = new HBox(10, passLabel, passField);
        passHBox.setAlignment(Pos.CENTER);

        Label loginWarning = new Label("Invalid credentials!");
        loginWarning.setTextFill(Color.RED);
        loginWarning.setVisible(false);
        loginWarning.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Button loginButton = new Button("Login");

        loginButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;");
        loginButton.setOnMouseEntered(e -> loginButton
                .setStyle("-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        loginButton.setOnMouseExited(e -> loginButton
                .setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));

        VBox loginLayout = new VBox(10, userHBox, passHBox, loginButton, loginWarning);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setPadding(new Insets(20));
        loginLayout.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, null, null)));

        Scene loginScene = new Scene(loginLayout, 700, 700);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.show();

        userField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DOWN) {
                passField.requestFocus();
            }
        });

        passField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                userField.requestFocus();
            }
            if (event.getCode() == KeyCode.ENTER) {
                loginButton.fire();
            }
        });

        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            if (username.equals("") && password.equals("")) {
                primaryStage.setX(400);
                primaryStage.setY(60);
                showMainUI(primaryStage);
            } else {
                loginWarning.setVisible(true);
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(2), evt -> loginWarning.setVisible(false)));
                timeline.setCycleCount(1);
                timeline.play();
            }
        });
        userField.requestFocus();
        loginButton.setDefaultButton(true);
    }

    private void showMainUI(Stage primaryStage) {
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.setX(400);
        primaryStage.setY(80);

        welcomeLabel = new Label("Welcome to the");
        welcomeLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        welcomeLabel.setTextFill(Color.WHITE);

        stdLabel = new Label("Student and Teacher");
        stdLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        stdLabel.setTextFill(Color.WHITE);

        infoLabel = new Label("Information Management System");
        infoLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        infoLabel.setTextFill(Color.WHITE);

        stimsLabel = new Label("STIMS");
        stimsLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 30));
        stimsLabel.setTextFill(Color.WHITE);

        promptLabel = new Label("Please select below:");
        promptLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        promptLabel.setTextFill(Color.WHITE);

        language = new ComboBox<>();
        language.getItems().addAll("English", "Arabic");
        language.setValue("English");
        language.setStyle(
                "-fx-font-size: 16px; -fx-font-weight: bold; -fx-background-color: transparent; -fx-text-fill: white;");
        language.setOnAction(e -> {
            setLanguage(language.getValue());
        });
        StackPane.setAlignment(language, Pos.TOP_RIGHT);

        language.getEditor().setStyle("-fx-text-fill: white;");

        language.setPromptText("Select Language");

        studentRadio = new RadioButton("Student");
        teacherRadio = new RadioButton("Teacher");
        studentRadio.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        teacherRadio.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        studentRadio.setTextFill(Color.WHITE);
        teacherRadio.setTextFill(Color.WHITE);

        ToggleGroup group = new ToggleGroup();
        studentRadio.setToggleGroup(group);
        teacherRadio.setToggleGroup(group);

        submitButton = new Button("Submit");

        submitButton.setDisable(true);
        group.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            submitButton.setDisable(newToggle == null);
        });

        submitButton.setOnAction(e -> {
            if (studentRadio.isSelected()) {
                // new Student().show();
                new Student(primaryStage).show();
            }
        });

        submitButton.setMinSize(100, 50);
        submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        submitButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;");
        submitButton.setOnMouseEntered(e -> submitButton
                .setStyle("-fx-background-color: #5A9BD3; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));
        submitButton.setOnMouseExited(e -> submitButton
                .setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-font-weight: bold; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 8px 20px;"));

        Image logo = new Image(
                "file:C:\\Users\\Issa\\Documents\\IntellijProjects\\STIMS\\src\\main\\resources\\assets\\logo.png");

        VBox mainLayout = new VBox(15, welcomeLabel, stdLabel, infoLabel, stimsLabel, promptLabel, studentRadio,
                teacherRadio,
                submitButton);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(28));
        mainLayout.setBackground(
                new Background(new BackgroundFill(
                        Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5), null, Insets.EMPTY)));

        ImageView logoView = new ImageView(logo);
        logoView.fitWidthProperty().bind(primaryStage.widthProperty().multiply(1));
        logoView.fitHeightProperty().bind(primaryStage.heightProperty().multiply(1));
        logoView.setOpacity(0.5);

        StackPane root = new StackPane(logoView, mainLayout, language);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("STIMS");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static String getLanguage() {
        return language.getValue();
    }

    public static void goToMainUI(Stage stage) {
        new Main().showMainUI(stage);
    }

    private void setLanguage(String lang) {
        if (lang.equals("English")) {
            System.out.println("Language set to English");
            welcomeLabel.setText("Welcome to the");
            stdLabel.setText("Student and Teacher");
            infoLabel.setText("Information Management System");
            stimsLabel.setText("STIMS");
            promptLabel.setText("Please select below:");
            submitButton.setText("Submit");
            studentRadio.setText("Students");
            teacherRadio.setText("Teachers");

        } else if (lang.equals("Arabic")) {
            System.out.println("Language is set to Arabic");
            welcomeLabel.setText("مرحباً بك في");
            stdLabel.setText("نظام إدارة معلومات");
            infoLabel.setText("الطلاب والمعلمين");
            stimsLabel.setText("STIMS");
            promptLabel.setText("الرجاء الاختيار أدناه:");
            submitButton.setText("إختيار");
            studentRadio.setText("الطلاب");
            teacherRadio.setText("المعلمين");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}