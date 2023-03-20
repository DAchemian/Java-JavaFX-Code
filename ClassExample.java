package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClassExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        Label instructions = new Label ("Please Enter the Following");
        gridPane.add(instructions, 0, 1);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        gridPane.add(nameLabel, 1, 0);
        gridPane.add(nameField, 2, 0);

        Label phoneLabel = new Label("Phone #:");
        TextField phoneField = new TextField();
        gridPane.add(phoneLabel, 1, 1);
        gridPane.add(phoneField, 2, 1);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        gridPane.add(emailLabel, 1, 2);
        gridPane.add(emailField, 2, 2);

        Button submitButton = new Button("Submit");
        gridPane.add(submitButton, 0, 3);
        
        Button cancelButton = new Button ("Cancel");
        gridPane.add(cancelButton, 2, 3);

        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String phoneNumber = phoneField.getText();
            String email = emailField.getText();
            System.out.println("Name: " + name);
            System.out.println("Phone #: " + phoneNumber);
            System.out.println("Email: " + email);
            System.out.println("Thank you for submitting!");
            
        });

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}