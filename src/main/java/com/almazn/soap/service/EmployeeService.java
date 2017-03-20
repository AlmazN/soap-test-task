package com.almazn.soap.service;

import com.almazn.soap.dao.DepartmentDAO;
import com.almazn.soap.model.Department;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EmployeeService {

    @WebMethod
    PutEmployeeResponseType putEmployee(String department, String firstName, String lastName, String middleName,
                                               String gender, String driverLicense);

    @WebMethod
    GetEmployeesResponseType getEmployees(String department);

    @WebMethod
    DepartmentDAO getDepartments();
}
