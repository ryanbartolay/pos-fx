package com.bartolay.inventory.interfaces;

import com.bartolay.inventory.entity.Category;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface CategoryInterface {
    
    public ObservableList<Category> CATEGORYLIST = FXCollections.observableArrayList();   
}
