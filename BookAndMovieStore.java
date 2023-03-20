//David Achemian
//CS 2450
//Class Assignment 3
//03.14.2023

package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BookAndMovieStore extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> bookListView = new ListView<>();
        bookListView.getItems().addAll("Holes", "Boy In The Striped Pajamas", "Of Mice and Men");

        ListView<String> movieListView = new ListView<>();
        movieListView.getItems().addAll("Schindler's List", "Apocalypse Now", "Saving Private Ryan");


        MenuBar menuBar = new MenuBar();

        Menu viewMenu = new Menu("View");
        ToggleGroup group = new ToggleGroup();
        RadioMenuItem booksRadio = new RadioMenuItem("Books");
        booksRadio.setToggleGroup(group);
        booksRadio.setSelected(true);
        RadioMenuItem moviesRadio = new RadioMenuItem("Movies");
        moviesRadio.setToggleGroup(group);
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem exitMenuItem = new MenuItem("Exit");

        viewMenu.getItems().addAll(booksRadio, moviesRadio, separator, exitMenuItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        helpMenu.getItems().add(aboutMenuItem);

        menuBar.getMenus().addAll(viewMenu, helpMenu);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(bookListView);

        booksRadio.setOnAction(event -> borderPane.setCenter(bookListView));
        moviesRadio.setOnAction(event -> borderPane.setCenter(movieListView));
        exitMenuItem.setOnAction(event -> primaryStage.close());
        aboutMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText(null);
            alert.setContentText("Book and Movie Store\nAuthor: David Achemian\nCopyright © 2023");
            alert.showAndWait();
        });

        primaryStage.setTitle("Book and Movie Store");
        primaryStage.setScene(new Scene(borderPane, 300, 250));
        primaryStage.show();
    }
}

