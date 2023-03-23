package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class OpacityAdjustor extends Application {

    private ImageView imageView;
    private Slider opacitySlider;

    @Override
    public void start(Stage primaryStage) {

        imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);

        opacitySlider = new Slider(0, 1, 1);
        opacitySlider.setOrientation(Orientation.HORIZONTAL);
        opacitySlider.setPrefWidth(200);

        Label opacityLabel = new Label("Opacity: 100%");
        opacityLabel.setPadding(new Insets(0, 0, 0, 20));

        opacitySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            imageView.setOpacity(newValue.doubleValue());
            int opacityPercent = (int) (newValue.doubleValue() * 100);
            opacityLabel.setText("Opacity: " + opacityPercent + "%");
        });

        Button openButton = new Button("Open Image");
        openButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Image");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
                imageView.setOpacity(1);
                opacitySlider.setValue(1);
            }
        });

        HBox sliderBox = new HBox(opacitySlider, opacityLabel);
        sliderBox.setSpacing(10);
        sliderBox.setPadding(new Insets(20, 0, 0, 0));

        StackPane stackPane = new StackPane(imageView, sliderBox);
        stackPane.setPadding(new Insets(20));

        Scene scene = new Scene(stackPane, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Opacity");
        primaryStage.show();

        opacitySlider.setDisable(true);

        imageView.imageProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                opacitySlider.setDisable(true);
            } else {
                opacitySlider.setDisable(false);
                openButton.setDisable(true);
            }
        });
        
        stackPane.getChildren().add(openButton);
        StackPane.setAlignment(openButton, javafx.geometry.Pos.BOTTOM_CENTER);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

