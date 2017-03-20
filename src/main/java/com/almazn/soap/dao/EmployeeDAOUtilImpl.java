package com.almazn.soap.dao;

import com.almazn.soap.model.Department;
import com.almazn.soap.model.Employee;
import com.almazn.soap.model.Gender;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.List;

@Repository("EmployeeDAO")
public class EmployeeDAOUtilImpl extends SpringBeanAutowiringSupport implements EmployeeDAOUtil {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(value = "transactionManager")
    public void putEmployee(String departmentStr, String firstName, String lastName, String middleName, Gender gender, String driverLicense)
            throws EmployeeDAOException {
        Department department = getDepartment(departmentStr);
        Employee employee = new Employee(firstName, lastName, middleName, gender, driverLicense, department.getId());
        sessionFactory.getCurrentSession().save(employee);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(value = "transactionManager")
    public List<Employee> getEmployees(String departmentStr) throws EmployeeDAOException {
        Department department = getDepartment(departmentStr);
        List<Employee> list = sessionFactory.getCurrentSession().createQuery("from Employee where departmentId = :departmentId")
                .setParameter("departmentId", department.getId())
                .list();

        return list;
    }

    @Override
    @Transactional(value = "transactionManager")
    public DepartmentDAO getDepartments() {
        Department mainDepartment = sessionFactory.getCurrentSession().load(Department.class, 1);
        return new DepartmentDAO(mainDepartment);
    }

    @Transactional(value = "transactionManager")
    private Department getDepartment(String departmentStr) throws EmployeeDAOException {
        Department result = null;
        Department mainDepartment = sessionFactory.getCurrentSession().load(Department.class, 1);
        String[] departments = departmentStr.split("\\|");

        if(mainDepartment.getName().equals(departments[0])) {
            result = mainDepartment;
            for(int i = 1; i < departments.length; i++) {
                result = getChild(result, departments[i]);
            }
        }

        if(result == null) {
            throw new EmployeeDAOException("Department not found!");
        }

        return result;
    }

    private Department getChild(Department parent, String name) {
        if(parent == null) {
            return null;
        }
        for(Department child : parent.getChildren()) {
            if(child.getName().equals(name)) {
                return child;
            }
        }
        return null;
    }

}