//David Achemian
//CS 2450
//Assignment 1
//02.27.2023

package application;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DiceRoller extends Application {

    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dice Roller");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);

        ImageView die1ImageView = new ImageView(new Image(getClass().getResourceAsStream("Die1.png")));
        ImageView die2ImageView = new ImageView(new Image(getClass().getResourceAsStream("Die1.png")));

        grid.add(die1ImageView, 0, 0);
        grid.add(die2ImageView, 1, 0);

        Button rollButton = new Button("Roll");
        grid.add(rollButton, 0, 1);

        rollButton.setOnAction(event -> {
            int die1Value = random.nextInt(6) + 1;
            int die2Value = random.nextInt(6) + 1;
            die1ImageView.setImage(new Image(getClass().getResourceAsStream("Die" + die1Value + ".png")));
            die2ImageView.setImage(new Image(getClass().getResourceAsStream("Die" + die2Value + ".png")));
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

