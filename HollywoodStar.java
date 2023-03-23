package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HollywoodStar extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Polygon star = new Polygon(
                100, 10,
                125, 70,
                195, 80,
                145, 130,
                160, 195,
                100, 160,
                40, 195,
                55, 130,
                5, 80,
                75, 70);
        
        star.setFill(Color.WHITE);
        star.setStroke(Color.BLACK);
        star.setStrokeWidth(2);

        Label nameLabel = new Label("David Achemian");
        nameLabel.setFont(Font.font("Times New Roman Black", 15));
        nameLabel.setTextFill(Color.BLACK);
        StackPane.setAlignment(nameLabel, Pos.CENTER);
        StackPane starPane = new StackPane(star, nameLabel);
        
        Scene scene = new Scene(starPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hollywood Walk of Fame Star");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

