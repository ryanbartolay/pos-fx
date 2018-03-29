package com.bartolay.inventory.interfaces;

import com.bartolay.inventory.entity.Supplier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface SupplierInterface {
    
    public ObservableList<Supplier> SUPPLIERLIST = FXCollections.observableArrayList();
}
