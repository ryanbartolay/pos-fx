package com.bartolay.inventory;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.bartolay.inventory.development.DevBootstrap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

	private double xOffset = 0;
	private double yOffset = 0;

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		root.setOnMousePressed((MouseEvent event) -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});
		root.setOnMouseDragged((MouseEvent event) -> {
			stage.setX(event.getScreenX() - xOffset);
			stage.setY(event.getScreenY() - yOffset);
		});
		Scene scene = new Scene(root);
		stage.setTitle("Inventory:: Version 1.0");
		stage.getIcons().add(new Image("/images/logo.png"));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.setSessionFactory();
			new DevBootstrap();
			launch(args);
			HibernateUtil.getSessionFactory().close();
		} catch(Exception e) {
			List<Throwable> throwables = ExceptionUtils.getThrowableList(e);

			Platform.runLater(() -> {
				String message = "";

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("An error has occured!");
				alert.setHeaderText("Database Connection Error!");

				if(throwables.size() > 0) {
					for(Throwable t : throwables) {
						message += t.getMessage() + "\n";
					}

					alert.setContentText(message);
				}
				
				alert.showAndWait();
				Platform.exit();
			});
		}

	}

}


//public class POSMain extends Application {
//
//	private GUI arena = new GUI(600, 600);
//	private 	Scene scene = new Scene(arena); 
//	
//	public static void main(String[] args) {
//		launch(args);
//	}
//	
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		 primaryStage.setTitle("POS - Main Page");
//		 
//		 scene.addEventFilter(KeyEvent.KEY_PRESSED, new BarcodeEventHandler());
//		 
//		 primaryStage.setScene(scene);
//		 primaryStage.show();
//	}
//
//}

