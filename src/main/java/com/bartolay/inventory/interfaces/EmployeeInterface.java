package com.bartolay.inventory.interfaces;

import com.bartolay.inventory.entity.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface EmployeeInterface {
    
    public ObservableList<Employee> EMPLOYEELIST = FXCollections.observableArrayList();
}
