package com.bartolay.inventory.controller.product;

import java.net.URL;
import java.util.ResourceBundle;

import com.bartolay.inventory.dao.impl.CategoryDaoImpl;
import com.bartolay.inventory.dao.impl.ProductDaoImpl;
import com.bartolay.inventory.dao.impl.SupplierDaoImpl;
import com.bartolay.inventory.entity.Category;
import com.bartolay.inventory.entity.Product;
import com.bartolay.inventory.entity.Supplier;
import com.bartolay.inventory.interfaces.ProductInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScanBarcodeController extends Pane implements Initializable, ProductInterface {

	@FXML
	private TextField nameField, priceField, quantityField;
	@FXML
	private TextArea descriptionArea;
	@FXML
	private ComboBox categoryBox, supplierBox;
	@FXML
	private Button saveButton;
	private ProductDaoImpl productModel;
	private CategoryDaoImpl categoryModel;
	private SupplierDaoImpl supplierModel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	@FXML
	public void handleSave(ActionEvent event) {

		if (validateInput()) {

			Category category = categoryModel.getCategory(categoryBox.getSelectionModel().getSelectedIndex() + 1);
			Supplier supplier = supplierModel.getSupplier(supplierBox.getSelectionModel().getSelectedIndex() + 1);
			Product product = new Product(
					nameField.getText(),
					Double.parseDouble(priceField.getText()),
					Double.parseDouble(quantityField.getText()),
					descriptionArea.getText(),
					category,
					supplier
					);

			productModel.saveProduct(product);
			PRODUCTLIST.clear();
			PRODUCTLIST.addAll(productModel.getProducts());

			((Stage) saveButton.getScene().getWindow()).close();

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Successful");
			alert.setHeaderText("Product is added");
			alert.setContentText("Product is added successfully");
			alert.showAndWait();
		}
	}

	@FXML
	public void handleCancel(ActionEvent event) {
		nameField.setText("");
		priceField.setText("");
		quantityField.setText("");
		descriptionArea.setText("");
		categoryBox.valueProperty().setValue(null);
	}

	private boolean validateInput() {

		String errorMessage = "";

		if (nameField.getText() == null || nameField.getText().length() == 0) {
			errorMessage += "No valid name!\n";
		}

		if (priceField.getText() == null || priceField.getText().length() == 0) {
			errorMessage += "No valid price!\n";
		}

		if (quantityField.getText() == null || quantityField.getText().length() == 0) {
			errorMessage += "No valid quantity!\n";
		}

		if (descriptionArea.getText() == null || descriptionArea.getText().length() == 0) {
			errorMessage += "No email description!\n";
		}

		if (categoryBox.getSelectionModel().isEmpty()) {
			errorMessage += "Please select the category!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();

			return false;
		}
	}

	@FXML
	public void closeAction(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private boolean spacebar = false;
	private boolean shift = false;
	private boolean ctrl = false;

	private double mouseX;
	private double mouseY;


	@FXML public void scanBarcodeAction(KeyEvent event) {
		System.out.println(event.getEventType().toString());

		if(event instanceof KeyEvent) {
			if(event.getSource() == getOnKeyPressed()) {
				keyPressed((KeyEvent) event);
			}
			if(event.getSource() == getOnKeyReleased()) {
				keyReleased((KeyEvent) event);
			}

			System.out.println(((KeyEvent) event).getCode());
		}
	}


	public void keyPressed(KeyEvent e) {
		KeyCode code = e.getCode();

		if (code == KeyCode.UP)
			up = true;
		if (code == KeyCode.DOWN)
			down = true;
		if (code == KeyCode.LEFT)
			left = true;
		if (code == KeyCode.RIGHT)
			right = true;
		if (code == KeyCode.SPACE)
			spacebar = true;
		if (code == KeyCode.SHIFT)
			shift = true;
		if (code == KeyCode.CONTROL)
			ctrl = true;
	}

	public void keyReleased(KeyEvent e) {
		KeyCode code = e.getCode();

		if (code == KeyCode.UP)
			up = false;
		if (code == KeyCode.DOWN)
			down = false;
		if (code == KeyCode.LEFT)
			left = false;
		if (code == KeyCode.RIGHT)
			right = false;
		if (code == KeyCode.SPACE)
			spacebar = false;
		if (code == KeyCode.SHIFT)
			shift = false;
		if (code == KeyCode.CONTROL)
			ctrl = false;
	}

}
