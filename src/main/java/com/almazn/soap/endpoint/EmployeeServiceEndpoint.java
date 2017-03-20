package com.almazn.soap.endpoint;

import com.almazn.soap.dao.DepartmentDAO;
import com.almazn.soap.model.Department;
import com.almazn.soap.model.Employee;
import com.almazn.soap.service.EmployeeService;
import com.almazn.soap.service.GetEmployeesResponseType;
import com.almazn.soap.service.PutEmployeeResponseType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.Holder;
import java.util.List;

@WebService(serviceName = "EmployeeService")
public class EmployeeServiceEndpoint {

    @Autowired
    private EmployeeService employeeService;

    @WebMethod
    public void putEmployee(@XmlElement(required=true)
                              @WebParam(name = "department") String department,
                              @XmlElement(required=true)
                              @WebParam(name = "firstName")String firstName,
                              @XmlElement(required=true) @WebParam(name = "lastName")String lastName,
                              @WebParam(name = "middleName")String middleName,
                              @XmlElement(required=true)
                              @WebParam(name = "gender")String gender,
                              @WebParam(name = "driverLicense")String driverLicense,
                              @WebParam(name = "resultCode", mode = WebParam.Mode.OUT) Holder<Integer> resultCode,
                              @WebParam(name = "description", mode = WebParam.Mode.OUT) Holder<String> description) {
        PutEmployeeResponseType response = employeeService.putEmployee(department, firstName, lastName, middleName, gender, driverLicense);
        resultCode.value = response.getResultCode();
        description.value = response.getDescription();
    }

    @WebMethod
    public void getEmployees(@XmlElement(required=true)
                             @WebParam(name = "department") String department,
                             @WebParam(name = "resultCode", mode = WebParam.Mode.OUT) Holder<Integer> resultCode,
                             @WebParam(name = "description", mode = WebParam.Mode.OUT) Holder<String> description,
                             @WebParam(name = "employees", mode = WebParam.Mode.OUT) Holder<List<Employee>> employees) {
        GetEmployeesResponseType response = employeeService.getEmployees(department);
        resultCode.value = response.getResultCode();
        description.value = response.getDescription();
        employees.value = response.getEmployees();
    }

    @WebMethod
    public void getDepartmentsStructure(
                            @WebParam(name = "mainDepartment", mode = WebParam.Mode.OUT) Holder<DepartmentDAO> departments) {
        departments.value = employeeService.getDepartments();
    }
}
