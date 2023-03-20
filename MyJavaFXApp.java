package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.*;

public class MyJavaFXApp extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label label = new Label("Name your favorite cannabis dispensary: ");
        TextField textField = new TextField();
        gridPane.add(label, 0, 4);
        gridPane.add(textField, 1, 4);

        Button button = new Button("Submit");
        gridPane.add(button, 1, 6);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Good stuff", "Pretty Mid Ngl", "Wouldn't buy for free");
        choiceBox.getSelectionModel().selectFirst();
        gridPane.add(new Label("Rating:"), 0, 5);
        gridPane.add(choiceBox, 0, 6);

        Scene scene = new Scene(gridPane, 1000, 1000);
        scene.getStylesheets().add("style.css");

        primaryStage.setTitle("My JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Image image = new Image("file:///user/dachemian/downloads/celeb-snoop.");
        ImageView view = new ImageView(image);
        view.setX(0);
        view.setY(0);
        view.setFitWidth(575);
        view.setPreserveRatio(true);
        
    }

}



