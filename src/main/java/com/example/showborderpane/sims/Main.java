package com.example.showborderpane.sims;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
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

import com.example.showborderpane.sims.Views.StudentView;

public class Main extends Application {

    private Label welcomeLabel;
    private Label infoLabel;
    private Label stimsLabel;
    private Label userLabel;
    private TextField userField;
    private Label passLabel;
    private TextField passField;
    private static ComboBox<String> language;

    @Override
    public void start(Stage primaryStage) {

        showMainUI(primaryStage);
    }

    private void showMainUI(Stage primaryStage) {

        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.setX(400);
        primaryStage.setY(80);
        primaryStage.setResizable(false);

        welcomeLabel = new Label("Welcome to the");
        welcomeLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        welcomeLabel.setTextFill(Color.WHITE);

        infoLabel = new Label("Student Information Management System");
        infoLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        infoLabel.setTextFill(Color.WHITE);

        stimsLabel = new Label("STIMS");
        stimsLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 30));
        stimsLabel.setTextFill(Color.WHITE);

        userLabel = new Label("Username");
        userLabel.setTextFill(Color.WHITE);
        userLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        userField = new TextField();
        userField.setStyle(
                "-fx-font-size: 16px; -fx-border-width: 2px; -fx-border-radius: 5px;");
        userField.setPrefWidth(250);

        HBox userHBox = new HBox(10, userLabel, userField);
        userHBox.setAlignment(Pos.CENTER);

        passLabel = new Label("Password");
        passLabel.setTextFill(Color.WHITE);
        passLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        passField = new PasswordField();
        passField.setPromptText("Enter password");
        passField.setStyle(
                "-fx-font-size: 16px;-fx-border-width: 2px; -fx-border-radius: 5px;");
        passField.setPrefWidth(250);

        HBox passHBox = new HBox(10, passLabel, passField);
        passHBox.setAlignment(Pos.CENTER);

        language = new ComboBox<>();
        language.getItems().clear();

        language.getItems().addAll("English", "Arabic");
        language.setValue("English");
        language.setStyle(
                "-fx-font-size: 16px; -fx-font-weight: bold; -fx-background-color: transparent; -fx-text-fill: white;");

        language.setOnAction(e -> setLanguage(language.getValue()));

        StackPane.setAlignment(language, Pos.TOP_RIGHT);

        Image logo = new Image(
                "file:C:\\Users\\Issa\\Documents\\IntellijProjects\\STIMS\\src\\main\\resources\\assets\\logo.png");

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

        VBox mainLayout = new VBox(15, welcomeLabel, infoLabel, stimsLabel, userHBox, passHBox, loginButton,
                loginWarning);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(28));
        mainLayout.setBackground(
                new Background(new BackgroundFill(
                        Color.DARKSLATEBLUE.deriveColor(0, 1, 1, 0.5), null, Insets.EMPTY)));

        ImageView logoView = new ImageView(logo);
        logoView.fitWidthProperty().bind(primaryStage.widthProperty().multiply(1));
        logoView.fitHeightProperty().bind(primaryStage.heightProperty().multiply(1));
        logoView.setOpacity(0.5);

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
                new StudentView(primaryStage).show();
            } else {
                loginWarning.setVisible(true);

            }
        });
        userField.requestFocus();
        loginButton.setDefaultButton(true);

        StackPane root = new StackPane(logoView, mainLayout, language);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("STIMS");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setLanguage(String lang) {
        if (lang.equals("English")) {
            System.out.println("Language set to English");
            welcomeLabel.setText("Welcome to the");
            infoLabel.setText("Student Information Management System");
            stimsLabel.setText("STIMS");
            userLabel.setText("Username:");
            passLabel.setText("Password:");
            userField.setPromptText("Enter username");
            passField.setPromptText("Enter password");

        } else if (lang.equals("Arabic")) {
            System.out.println("Language is set to Arabic");
            welcomeLabel.setText("مرحباً بك في");
            infoLabel.setText("نظام إدارة معلومات الطلاب");
            stimsLabel.setText("STIMS");
            userLabel.setText(":اسم المستخدم");
            passLabel.setText(":كلمة المرور");
            userField.setPromptText("أدخل اسم المستخدم");
            passField.setPromptText("أدخل كلمة المرور");

        }
    }

    public static String getLanguage() {
        return language.getValue();
    }

    public static void goToMainUI(Stage stage) {
        new Main().showMainUI(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}