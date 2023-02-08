package com.example.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
	private HelloController controller;

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("game.fxml"));
		GridPane rootGridPane = loader.load();

		controller = loader.getController();
		controller.createPlayerground();

		MenuBar menuBar = createMenu();
		menuBar.prefWidthProperty().bind(stage.widthProperty());

		Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		Scene scene = new Scene(rootGridPane);

		stage.setTitle("ConnectFour");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public MenuBar createMenu(){

		//File Menu Action or Interaction With User

		Menu fileMenu = new Menu("File");

		MenuItem newGame = new MenuItem("New Game");
		newGame.setOnAction(actionEvent -> controller.resetGame());

		MenuItem resetGame = new MenuItem("Reset Game");
		resetGame.setOnAction(actionEvent -> controller.resetGame());

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem exitGame = new MenuItem("Exit Game");
		exitGame.setOnAction(actionEvent -> {
			exitGame();
		});

		fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

		Menu helpMenu = new Menu("Help");

		MenuItem aboutGame = new MenuItem("About Connect Four");
		aboutGame.setOnAction(actionEvent -> {
			aboutConnect4();
		});
		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuItem aboutMe = new MenuItem("About Me");
		aboutMe.setOnAction(actionEvent -> {
			aboutMe();
		});

		helpMenu.getItems().addAll(aboutGame,separator,aboutMe);

		MenuBar menuBar = new MenuBar();

		menuBar.getMenus().addAll(fileMenu,helpMenu);

		return menuBar;
	}

	private void aboutConnect4() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About the Game");
		alert.setHeaderText(" How To Play");
		alert.setContentText("Connect Four is a two-player strategy game "+
				"in which players take turns dropping colored disks into a vertical grid."+" The objective of the game is to connect " +
				"four of one's own disks of the s" +
				"ame color horizontally, vertically, or diagonally before the opponent does. " +
				"The game can be won by either player if the grid is filled and neither has four in a row" +
				", or if neither player can make a move. It is also known as \"Four in a Row\" or \"Captain's Mistress\".");
		alert.show();
	}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About the Creator");
		alert.setHeaderText(" Nikhil Singh");
		alert.setContentText("I like to create and this my creation");
		alert.show();
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}


	public static void main(String[] args) {
		launch(args);
	}
}