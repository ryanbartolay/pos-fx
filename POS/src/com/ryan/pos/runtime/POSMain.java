package com.ryan.pos.runtime;

import com.ryan.pos.pane.GUI;
import com.ryan.post.event.handler.BarcodeEventHandler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class POSMain extends Application {

	private GUI arena = new GUI(600, 600);
	private 	Scene scene = new Scene(arena); 
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		 primaryStage.setTitle("POS - Main Page");
		 
		 scene.addEventFilter(KeyEvent.KEY_PRESSED, new BarcodeEventHandler());
		 
		 primaryStage.setScene(scene);
		 primaryStage.show();
	}

}
