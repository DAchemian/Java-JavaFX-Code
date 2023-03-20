//David Achemian
//CS 2450
//Assignment 1
//02.27.2023

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RestaurantTipCalculator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Restaurant Tip Calculator");
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);

        Label foodChargeLabel = new Label("Food Charge:");
        grid.add(foodChargeLabel, 0, 0);
        
        TextField foodChargeTextField = new TextField();
        grid.add(foodChargeTextField, 1, 0);
        
        Button calculateButton = new Button("Calculate");
        grid.add(calculateButton, 0, 1);
        
        Label tipLabel = new Label("Tip (18%):");
        grid.add(tipLabel, 0, 2);
        
        Label tipValueLabel = new Label();
        grid.add(tipValueLabel, 1, 2);
        
        Label salesTaxLabel = new Label("Sales Tax (7%):");
        grid.add(salesTaxLabel, 0, 3);
        
        Label salesTaxValueLabel = new Label();
        grid.add(salesTaxValueLabel, 1, 3);
        
        Label totalLabel = new Label("Total:");
        grid.add(totalLabel, 0, 4);
        
        Label totalValueLabel = new Label();
        grid.add(totalValueLabel, 1, 4);
        
        calculateButton.setOnAction(event -> {
            try {
                double foodCharge = Double.parseDouble(foodChargeTextField.getText());
                double tip = foodCharge * 0.18;
                double salesTax = foodCharge * 0.07;
                double total = foodCharge + tip + salesTax;
                
                tipValueLabel.setText(String.format("$%.2f", tip));
                salesTaxValueLabel.setText(String.format("$%.2f", salesTax));
                totalValueLabel.setText(String.format("$%.2f", total));
            } catch (NumberFormatException e) {
                tipValueLabel.setText("");
                salesTaxValueLabel.setText("");
                totalValueLabel.setText("");
            }
        });
        
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

