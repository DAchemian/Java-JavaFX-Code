package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;


public class GraphBuilding extends Application 
{	
	@Override
	public void start(Stage primaryStage) 
	{	
		CategoryAxis hAxis = new CategoryAxis();
		hAxis.setLabel("Teams");
		NumberAxis vAxis = new NumberAxis();
		vAxis.setLabel("Points per Game");
		ScatterChart<String, Number> scatter = new ScatterChart<>(hAxis, vAxis);
		scatter.setTitle("Scoring per Team");
		
		XYChart.Series<String, Number> januaryPoints = new XYChart.Series<>();
		januaryPoints.setName("January");
		januaryPoints.getData().add(new XYChart.Data<>("Clippers", 1212));
		januaryPoints.getData().add(new XYChart.Data<>("Hornets", 950));
		januaryPoints.getData().add(new XYChart.Data<>("Lakers", 1224));
		
		XYChart.Series<String, Number> februaryPoints = new XYChart.Series<>();
		februaryPoints.setName("February");
		februaryPoints.getData().add(new XYChart.Data<>("Clippers", 1090));
		februaryPoints.getData().add(new XYChart.Data<>("Hornets", 1200));
		februaryPoints.getData().add(new XYChart.Data<>("Lakers", 1101));
		
		XYChart.Series<String, Number> marchPoints = new XYChart.Series<>();
		marchPoints.setName("March");
		marchPoints.getData().add(new XYChart.Data<>("Clippers", 980));
		marchPoints.getData().add(new XYChart.Data<>("Hornets", 1250));
		marchPoints.getData().add(new XYChart.Data<>("Lakers", 1050));
		
		scatter.getData().add(januaryPoints);
		scatter.getData().add(februaryPoints);
		scatter.getData().add(marchPoints);
		scatter.setLegendVisible(true);
		
		
		CategoryAxis hAxis1 = new CategoryAxis();
		hAxis1.setLabel("Teams");
		NumberAxis vAxis1 = new NumberAxis();
		vAxis1.setLabel("Points per Game");
	
		StackedBarChart<String, Number> bar = new StackedBarChart<>(hAxis1, vAxis1);
		bar.setTitle("Scoring per Team");
		
		XYChart.Series<String, Number> januaryPoints1 = new XYChart.Series<>();
		januaryPoints1.setName("January");
		januaryPoints1.getData().add(new XYChart.Data<>("Clippers", 1212));
		januaryPoints1.getData().add(new XYChart.Data<>("Hornets", 950));
		januaryPoints1.getData().add(new XYChart.Data<>("Lakers", 1224));
		
		XYChart.Series<String, Number> februaryPoints1 = new XYChart.Series<>();
		februaryPoints1.setName("February");
		februaryPoints1.getData().add(new XYChart.Data<>("Clippers", 1090));
		februaryPoints1.getData().add(new XYChart.Data<>("Hornets", 1200));
		februaryPoints1.getData().add(new XYChart.Data<>("Lakers", 1101));
		
		XYChart.Series<String, Number> marchPoints1 = new XYChart.Series<>();
		marchPoints1.setName("March");
		marchPoints1.getData().add(new XYChart.Data<>("Clippers", 980));
		marchPoints1.getData().add(new XYChart.Data<>("Hornets", 1250));
		marchPoints1.getData().add(new XYChart.Data<>("Lakers", 1050));
		
		bar.getData().add(januaryPoints1);
		bar.getData().add(februaryPoints1);
		bar.getData().add(marchPoints1);
		bar.setLegendVisible(true);
		
		
		CategoryAxis hAxis2 = new CategoryAxis();
		hAxis2.setLabel("Teams");
		NumberAxis vAxis2 = new NumberAxis();
		vAxis2.setLabel("Points per Game");
		
		AreaChart<String, Number> area = new AreaChart<>(hAxis2, vAxis2);
		area.setTitle("Scoring per Team");
		
		XYChart.Series<String, Number> januaryPoints3 = new XYChart.Series<>();
		januaryPoints3.setName("January");
		januaryPoints3.getData().add(new XYChart.Data<>("Clippers", 1212));
		januaryPoints3.getData().add(new XYChart.Data<>("Hornets", 950));
		januaryPoints3.getData().add(new XYChart.Data<>("Lakers", 1224));
		
		XYChart.Series<String, Number> februaryPoints3 = new XYChart.Series<>();
		februaryPoints3.setName("February");
		februaryPoints3.getData().add(new XYChart.Data<>("Clippers", 1090));
		februaryPoints3.getData().add(new XYChart.Data<>("Hornets", 1200));
		februaryPoints3.getData().add(new XYChart.Data<>("Lakers", 1101));
		
		XYChart.Series<String, Number> marchPoints3 = new XYChart.Series<>();
		marchPoints3.setName("March");
		marchPoints3.getData().add(new XYChart.Data<>("Clippers", 980));
		marchPoints3.getData().add(new XYChart.Data<>("Hornets", 1250));
		marchPoints3.getData().add(new XYChart.Data<>("Lakers", 1050));
		
		area.getData().add(januaryPoints3);
		area.getData().add(februaryPoints3);
		area.getData().add(marchPoints3);
		area.setLegendVisible(true);
		
		CategoryAxis hAxis3 = new CategoryAxis();
		hAxis3.setLabel("Teams");
		NumberAxis vAxis3 = new NumberAxis();
		vAxis3.setLabel("Points per Game");
		
		LineChart<String, Number> line = new LineChart<>(hAxis3, vAxis3);
		line.setTitle("Scoring per Team");
		
		XYChart.Series<String, Number> januaryPoints2 = new XYChart.Series<>();
		januaryPoints2.setName("January");
		januaryPoints2.getData().add(new XYChart.Data<>("Clippers", 1212));
		januaryPoints2.getData().add(new XYChart.Data<>("Hornets", 950));
		januaryPoints2.getData().add(new XYChart.Data<>("Lakers", 1224));
		
		XYChart.Series<String, Number> februaryPoints2 = new XYChart.Series<>();
		februaryPoints2.setName("February");
		februaryPoints2.getData().add(new XYChart.Data<>("Clippers", 1090));
		februaryPoints2.getData().add(new XYChart.Data<>("Hornets", 1200));
		februaryPoints2.getData().add(new XYChart.Data<>("Lakers", 1101));
		
		XYChart.Series<String, Number> marchPoints2 = new XYChart.Series<>();
		marchPoints2.setName("March");
		marchPoints2.getData().add(new XYChart.Data<>("Clippers", 980));
		marchPoints2.getData().add(new XYChart.Data<>("Hornets", 1250));
		marchPoints2.getData().add(new XYChart.Data<>("Lakers", 1050));
		
		line.getData().add(januaryPoints2);
		line.getData().add(februaryPoints2);
		line.getData().add(marchPoints2);
		line.setLegendVisible(true);
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10));
		gridpane.setHgap(100);
		gridpane.setVgap(100);
		
		gridpane.add(scatter, 0, 1);
		gridpane.add(bar, 1, 1);
		gridpane.add(area, 0, 2);
		gridpane.add(line, 1, 2);
		
		Scene scene = new Scene(gridpane, 1200, 1200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Graph Building Examples");
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}