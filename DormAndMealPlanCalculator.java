//David Achemian
//CS 2450
//Homework 4
//03.02.2023

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DormAndMealPlanCalculator extends Application {

    private Label dormLabel;
    private ChoiceBox<String> dormChoiceBox;
    private Label mealLabel;
    private ChoiceBox<String> mealChoiceBox;
    private Button submitButton;
    private Label totalLabel;

    @Override
    public void start(Stage stage) {
        dormLabel = new Label("Select a dorm:");
        dormChoiceBox = new ChoiceBox<>();
        dormChoiceBox.getItems().addAll("Allen Hall", "Pike Hall", "Farthing Hall", "University Suites");
        mealLabel = new Label("Select a meal plan:");
        mealChoiceBox = new ChoiceBox<>();
        mealChoiceBox.getItems().addAll("7 meals per week", "14 meals per week", "Unlimited Meals");
        submitButton = new Button("Submit");
        totalLabel = new Label();

        // Set the fonts, colors and sizes of the UI elements
        Font labelFont = new Font("Times New Roman", 20);
        dormLabel.setFont(labelFont);
        dormLabel.setTextFill(Color.GREEN); // Set text color to green
        mealLabel.setFont(labelFont);
        mealLabel.setTextFill(Color.GREEN); // Set text color to green

        Font buttonFont = new Font("Times New Roman", 20);
        submitButton.setFont(buttonFont);
        submitButton.setTextFill(Color.GREEN); // Set text color to green

        Font totalFont = new Font("Times New Roman", 20);
        totalLabel.setFont(totalFont);
        totalLabel.setTextFill(Color.GREEN); // Set text color to green


        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(dormLabel, dormChoiceBox, mealLabel, mealChoiceBox, submitButton, totalLabel);
        layout.setStyle("-fx-background-color: yellow; -fx-border-color: green; -fx-border-width: 8px;");

        submitButton.setOnAction(event -> calculateTotal());

        Scene scene = new Scene(layout, 300, 300);
        stage.setTitle("Dorm and Meal Plan Calculator");
        stage.setScene(scene);
        stage.show();
    }

    // Calculations are done here
    private void calculateTotal() {
        String dorm = dormChoiceBox.getValue();
        String meal = mealChoiceBox.getValue();
        int dormPrice = 0;
        int mealPrice = 0;

        switch (dorm) {
            case "Allen Hall":
                dormPrice = 1800;
                break;
            case "Pike Hall":
                dormPrice = 2200;
                break;
            case "Farthing Hall":
                dormPrice = 2800;
                break;
            case "University Suites":
                dormPrice = 3000;
                break;
        }

        switch (meal) {
            case "7 meals per week":
                mealPrice = 600;
                break;
            case "14 meals per week":
                mealPrice = 1100;
                break;
            case "Unlimited Meals":
                mealPrice = 1800;
                break;
        }

        int total = dormPrice + mealPrice;
        totalLabel.setText("Total Charges: $" + total);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*import javafx.application.Application; My other attempts at writing this code, kept in for reference
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/*public class DormAndMealPlanCalculator extends Application {

    private static final double ALLEN_HALL_RATE = 1800.0;
    private static final double PIKE_HALL_RATE = 2200.0;
    private static final double FARTHING_HALL_RATE = 2800.0;
    private static final double UNIVERSITY_SUITES_RATE = 3000.0;

    private static final double MEAL_PLAN_7_RATE = 600.0;
    private static final double MEAL_PLAN_14_RATE = 1100.0;
    private static final double MEAL_PLAN_UNLIMITED_RATE = 1800.0;

    private Label totalLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create a label and a choice box for selecting the dormitory
        Label dormLabel = new Label("Select a dormitory:");
        ChoiceBox<String> dormChoiceBox = new ChoiceBox<>();
        dormChoiceBox.getItems().addAll("Allen Hall", "Pike Hall", "Farthing Hall", "University Suites");
        gridPane.add(dormLabel, 0, 0);
        gridPane.add(dormChoiceBox, 1, 0);

        // Create a label and a choice box for selecting the meal plan
        Label mealLabel = new Label("Select a meal plan:");
        ChoiceBox<String> mealChoiceBox = new ChoiceBox<>();
        mealChoiceBox.getItems().addAll("7 meals per week", "14 meals per week", "Unlimited meals");
        gridPane.add(mealLabel, 0, 1);
        gridPane.add(mealChoiceBox, 1, 1);
        
        Scene scene = new Scene(gridPane, 400, 300);
        scene.getStylesheets().add("style.css");

        // Create a button to calculate the charges and display the result
        Button submitButton = new Button("Submit");
        submitButton.getStyleClass().add("submit-button");
        gridPane.add(submitButton, 1, 2);

        totalLabel = new Label();
        totalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(totalLabel, 0, 3, 2, 1);

        // Add an event handler to the submit button to calculate the charges and display the result
        submitButton.setOnAction(e -> {
            double dormRate = 0.0;
            double mealRate = 0.0;
            double totalCharges = 0.0;
            
            String selectedMeal = mealChoiceBox.getSelectionModel().getSelectedItem();
            if (selectedMeal != null) {
                switch (selectedMeal) {
                    case "7 meals per week":
                        mealRate = MEAL_PLAN_7_RATE;
                        break;
                    case "14 meals per week":
                        mealRate = MEAL_PLAN_14_RATE;
                        
                }
            }

            String selectedDorm = dormChoiceBox.getSelectionModel().getSelectedItem();
            if (selectedDorm != null) {
                switch (selectedDorm) {
                    case "Allen Hall":
                        dormRate = ALLEN_HALL_RATE;
                        break;
                    case "Pike Hall":
                        dormRate = PIKE_HALL_RATE;
                        break;
                    case "Farthing Hall":
                        dormRate = FARTHING_HALL_RATE;
                        break;
                    case "University Suites":
                        dormRate = UNIVERSITY_SUITES_RATE;
                        break;
                }
            }
        });
        
            
    
    }
}

public class DormAndMealPlanCalculator extends Application {

    private double dormRate;
    private double mealRate;

    private Label totalLabel;

    public DormAndMealPlanCalculator(double dormRate, double mealRate) {
        this.dormRate = dormRate;
        this.mealRate = mealRate;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create a label and a choice box for selecting the dormitory
        Label dormLabel = new Label("Select a dormitory:");
        ChoiceBox<String> dormChoiceBox = new ChoiceBox<>();
        dormChoiceBox.getItems().addAll("Allen Hall", "Pike Hall", "Farthing Hall", "University Suites");
        gridPane.add(dormLabel, 0, 0);
        gridPane.add(dormChoiceBox, 1, 0);

        // Create a label and a choice box for selecting the meal plan
        Label mealLabel = new Label("Select a meal plan:");
        ChoiceBox<String> mealChoiceBox = new ChoiceBox<>();
        mealChoiceBox.getItems().addAll("7 meals per week", "14 meals per week", "Unlimited meals");
        gridPane.add(mealLabel, 0, 1);
        gridPane.add(mealChoiceBox, 1, 1);
        
        Scene scene = new Scene(gridPane, 400, 300);
        scene.getStylesheets().add("style.css");

        // Create a button to calculate the charges and display the result
        Button submitButton = new Button("Submit");
        submitButton.getStyleClass().add("submit-button");
        gridPane.add(submitButton, 1, 2);

        totalLabel = new Label();
        totalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(totalLabel, 0, 3, 2, 1);

        // Add an event handler to the submit button to calculate the charges and display the result
        submitButton.setOnAction(e -> {
            String selectedMeal = mealChoiceBox.getSelectionModel().getSelectedItem();
            if (selectedMeal != null) {
                switch (selectedMeal) {
                    case "7 meals per week":
                        mealRate = 600.0;
                        break;
                    case "14 meals per week":
                        mealRate = 1100.0;
                        break;
                    case "Unlimited meals":
                        mealRate = 1800.0;
                        break;
                }
            }

            String selectedDorm = dormChoiceBox.getSelectionModel().getSelectedItem();
            if (selectedDorm != null) {
                switch (selectedDorm) {
                    case "Allen Hall":
                        dormRate = 1800.0;
                        break;
                    case "Pike Hall":
                        dormRate = 2200.0;
                        break;
                    case "Farthing Hall":
                        dormRate = 2800.0;
                        break;
                    case "University Suites":
                        dormRate = 3000.0;
                        break;
                }
            }

            double totalCharges = dormRate + mealRate;
            totalLabel.setText("Total Charges: $" + totalCharges);
        });
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dorm and Meal Plan Calculator");
        primaryStage.show();
    }
}*/

      


                
            
        
    



    


                       

