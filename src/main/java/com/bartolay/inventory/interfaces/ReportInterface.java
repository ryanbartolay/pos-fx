package com.bartolay.inventory.interfaces;

import com.bartolay.inventory.entity.Invoice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface ReportInterface {
 
    public ObservableList<Invoice> REPORTLIST = FXCollections.observableArrayList();
}
