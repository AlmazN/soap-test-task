package com.almazn.soap.service;


import com.almazn.soap.model.Employee;

import java.util.List;

public class GetEmployeesResponseType {
    private int resultCode;
    private List<Employee> employees;
    private String description;

    public GetEmployeesResponseType(int resultCode, List<Employee> employees, String description) {
        this.resultCode = resultCode;
        this.employees = employees;
        this.description = description;
    }

  public int getResultCode() {
    return resultCode;
  }

  public void setResultCode(int resultCode) {
    this.resultCode = resultCode;
  }

  public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
