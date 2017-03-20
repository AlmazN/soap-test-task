package com.almazn.soap.service;

import com.almazn.soap.dao.DepartmentDAO;
import com.almazn.soap.dao.EmployeeDAOUtil;
import com.almazn.soap.model.Department;
import com.almazn.soap.model.Employee;
import com.almazn.soap.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import java.util.List;

public class EmployeeServiceImpl extends SpringBeanAutowiringSupport implements EmployeeService {

    @Autowired
    private EmployeeDAOUtil employeeDAOUtil;

    @Override
    @WebMethod
    public PutEmployeeResponseType putEmployee(String department, String firstName, String lastName, String middleName, String genderStr,
                                               String driverLicense) {
        try {
            validate(department, firstName, lastName, middleName, driverLicense);
            Gender gender = getGender(genderStr);
            employeeDAOUtil.putEmployee(department, firstName, lastName, middleName, gender, driverLicense);
            return new PutEmployeeResponseType(1, "Employee has been put.");
        } catch (Exception e) {
            return new PutEmployeeResponseType(-1, e.getMessage());
        }
    }

    @Override
    @WebMethod
    public GetEmployeesResponseType getEmployees(String department) {
        try {
            List<Employee> employees = employeeDAOUtil.getEmployees(department);
            if (employees.size() > 0) {
                return new GetEmployeesResponseType(1, employees, String.format("Found %d employees.", employees.size()));
            } else {
                return new GetEmployeesResponseType(0, employees, "No employees found.");
            }
        } catch (Exception e) {
            return new GetEmployeesResponseType(-1, null, e.getMessage());
        }
    }

    @Override
    @WebMethod
    public DepartmentDAO getDepartments() {
        return employeeDAOUtil.getDepartments();
    }


    private Gender getGender(String genderStr) {
        switch (genderStr) {
            case "MALE":
                return Gender.MALE;
            case "FEMALE":
                return Gender.FEMALE;
            default:
                throw new IllegalArgumentException("Wrong gender parameter!");
        }
    }

    private void validate(String department, String firstName, String lastName, String middleName, String driverLicense) {
        validate(department, "department", false, null);
        validate(firstName, "firstName", false, 50);
        validate(lastName, "lastName", false, 50);
        validate(middleName, "middleName", true, 50);
        validate(driverLicense, "driverLicense", true, 20);
    }

    private void validate(String value, String description, boolean nullable, Integer length) {
        if(!nullable && (value == null || value.isEmpty())) {
            throw new IllegalArgumentException("Parameter " + description + " is empty!");
        }
        if(value != null && length != null) {
            if(value.length() > length) {
                throw new IllegalArgumentException("Parameter " + description + " is too long!");
            }
        }
    }
}