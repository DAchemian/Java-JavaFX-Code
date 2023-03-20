import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Button extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        Label phoneLabel = new Label("Phone #:");
        TextField phoneField = new TextField();
        gridPane.add(phoneLabel, 0, 1);
        gridPane.add(phoneField, 1, 1);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailField, 1, 2);

        // Add a Submit button
        Button submitButton = new Button("Submit");
        gridPane.add(submitButton, 1, 3);

        // Add an event handler to the submit button to display the information on the console
        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String phoneNumber = phoneField.getText();
            String email = emailField.getText();
            System.out.println("Name: " + name);
            System.out.println("Phone #: " + phoneNumber);
            System.out.println("Email: " + email);
            System.out.println("Thank you for submitting!");
        });

        // Create a new scene with the GridPane and set it as the primary stage's scene
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}