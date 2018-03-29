package com.bartolay.inventory.interfaces;

import com.bartolay.inventory.entity.Sale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface SaleInterface {

    public ObservableList<Sale> SALELIST = FXCollections.observableArrayList();
}
