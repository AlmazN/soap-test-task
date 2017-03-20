package com.almazn.soap.dao;

import com.almazn.soap.model.Department;
import com.almazn.soap.model.Employee;
import com.almazn.soap.model.Gender;

import java.util.List;

public interface EmployeeDAOUtil {

    void putEmployee(String department, String firstName, String lastName, String middleName, Gender gender, String driverLicense)
            throws EmployeeDAOException;

    List<Employee> getEmployees(String department) throws EmployeeDAOException;

    DepartmentDAO getDepartments();
}
