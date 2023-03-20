//David Achemian
//CS 2450
//Assignment 2
//03.06.2023

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SkateShopApplication extends Application {
    
    // Skateboard products
    private static final String[] DECKS = {"The Master Thrasher ($60)", "The Dictator ($45)", "The Street King ($50)"};
    private static final String[] TRUCK_ASSEMBLIES = {"7.75-inch axle ($35)", "8-inch axle ($40)", "8.5-inch axle ($45)"};
    private static final String[][] WHEEL_SETS = {{"51 mm ($20)"}, {"55 mm ($22)"}, {"58 mm ($24)"}, {"61 mm ($28)"}};
    
    // Miscellaneous products
    private static final String[] MISC_PRODUCTS = {"Grip tape ($10)", "Bearings ($30)", "Riser pads ($2)", "Nuts & bolts kit ($3)"};
    private static final double[] MISC_PRICES = {10.0, 30.0, 2.0, 3.0};
    
    private ComboBox<String> deckComboBox;
    private ComboBox<String> truckComboBox;
    private ListView<String> wheelListView;
    private CheckBox[] miscCheckBoxes;
    private Label subtotalLabel;
    private Label taxLabel;
    private Label totalLabel;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Skate Shop");
        
        // Create UI elements
        deckComboBox = new ComboBox<>();
        deckComboBox.getItems().addAll(DECKS);
        
        truckComboBox = new ComboBox<>();
        truckComboBox.getItems().addAll(TRUCK_ASSEMBLIES);
        
        wheelListView = new ListView<>();
        wheelListView.getItems().addAll(WHEEL_SETS[0]);
        wheelListView.getItems().addAll(WHEEL_SETS[1]);
        wheelListView.getItems().addAll(WHEEL_SETS[2]);
        wheelListView.getItems().addAll(WHEEL_SETS[3]);
        wheelListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        wheelListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updatePriceLabels();
        });

        
        miscCheckBoxes = new CheckBox[MISC_PRODUCTS.length];
        for (int i = 0; i < MISC_PRODUCTS.length; i++) {
            miscCheckBoxes[i] = new CheckBox(MISC_PRODUCTS[i]);
            miscCheckBoxes[i].setOnAction(event -> {
                updatePriceLabels();
            });
        }
        
        subtotalLabel = new Label("$0.00");
        taxLabel = new Label("$0.00");
        totalLabel = new Label("$0.00");
        
        Button orderButton = new Button("Place Order");
        orderButton.setOnAction(event -> {
        });
        
        // Create UI layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.add(new Label("Select a deck:"), 0, 0);
        gridPane.add(deckComboBox, 1, 0);
        gridPane.add(new Label("Select a truck assembly:"), 0, 1);
        gridPane.add(truckComboBox, 1, 1);
        gridPane.add(new Label("Select a wheel set:"), 0, 2);
        gridPane.add(wheelListView, 1, 2);
        HBox miscHBox = new HBox(10);
        miscHBox.setAlignment(Pos.CENTER_LEFT);
        miscHBox.getChildren().addAll(miscCheckBoxes);
        gridPane.add(new Label("Select any additional items:"), 0, 3);
        gridPane.add(miscHBox, 1, 3);
        gridPane.add(new Label("Subtotal:"), 0, 4);
        gridPane.add(subtotalLabel, 1, 4);
        gridPane.add(new Label("Sales tax (7%):"), 0, 5);
        gridPane.add(taxLabel, 1, 5);
        gridPane.add(new Label("Total:"), 0, 6);
        gridPane.add(totalLabel, 1, 6);
        gridPane.add(orderButton, 0, 7, 2, 1);

        Scene scene = new Scene(gridPane, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        deckComboBox.getSelectionModel().selectFirst();
        truckComboBox.getSelectionModel().selectFirst();
        wheelListView.getSelectionModel().selectFirst();
        miscCheckBoxes[0].setSelected(true);

        updatePriceLabels();
    }

    private void updatePriceLabels() {
        double subtotal = 0.0;
        
        // Calculate sub-total based on selected items
        switch (deckComboBox.getSelectionModel().getSelectedIndex()) {
            case 0:
                subtotal += 60.0;
                break;
            case 1:
                subtotal += 45.0;
                break;
            case 2:
                subtotal += 50.0;
                break;
        }
        switch (truckComboBox.getSelectionModel().getSelectedIndex()) {
            case 0:
                subtotal += 35.0;
                break;
            case 1:
                subtotal += 40.0;
                break;
            case 2:
                subtotal += 45.0;
                break;
        }
        for (String wheel : wheelListView.getSelectionModel().getSelectedItems()) {
            switch (wheel) {
                case "51 mm ($20)":
                    subtotal += 20.0;
                    break;
                case "55 mm ($22)":
                    subtotal += 22.0;
                    break;
                case "58 mm ($24)":
                    subtotal += 24.0;
                    break;
                case "61 mm ($28)":
                    subtotal += 28.0;
                    break;
            }
        }

        for (int i = 0; i < miscCheckBoxes.length; i++) {
            if (miscCheckBoxes[i].isSelected()) {
                subtotal += MISC_PRICES[i];
            }
        }
        subtotalLabel.setText(String.format("$%.2f", subtotal));
        
        // Calculate tax and total
        double tax = subtotal * 0.07;
        taxLabel.setText(String.format("$%.2f", tax));
        double total = subtotal + tax;
        totalLabel.setText(String.format("$%.2f", total));
    }
}

