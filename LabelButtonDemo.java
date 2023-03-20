package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabelButtonDemo extends Application {
    private VBox vBox;

    @Override
    public void start(Stage primaryStage) {
        vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        // create three Label/Button pairs in HBoxes
        HBox hbox1 = createHBox("Acura", "Remove");
        HBox hbox2 = createHBox("Nissan", "Remove");
        HBox hbox3 = createHBox("Toyota", "Remove");

        // add the HBoxes to the VBox
        vBox.getChildren().addAll(hbox1, hbox2, hbox3);

        removeAcura.setOnAction(event){
        	rootVBox.getChildren().remove(acuraHBox);
        };

        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setTitle("Label/Button Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createHBox(String labelText, String buttonText) {
        Label label = new Label(labelText);
        Button button = new Button(buttonText);
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(label, button);
        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
