package com.bartolay.inventory.interfaces;

import com.bartolay.inventory.entity.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface ProductInterface {
    
    public ObservableList<Product> PRODUCTLIST = FXCollections.observableArrayList();   
}
