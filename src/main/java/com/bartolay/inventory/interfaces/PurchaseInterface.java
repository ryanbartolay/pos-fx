package com.bartolay.inventory.interfaces;

import com.bartolay.inventory.entity.Purchase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface PurchaseInterface {
    
    public ObservableList<Purchase> PURCHASELIST = FXCollections.observableArrayList();
}
