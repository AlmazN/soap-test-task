package com.almazn.soap.dao;

import com.almazn.soap.model.Department;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
    private String name;
    private Set<DepartmentDAO> department = new HashSet<>();

    public DepartmentDAO(Department mainDepartment) {
        this.name = mainDepartment.getName();
        for(Department child : mainDepartment.getChildren()) {
            department.add(new DepartmentDAO(child));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DepartmentDAO> getDepartment() {
        return department;
    }

    public void setDepartment(Set<DepartmentDAO> department) {
        this.department = department;
    }

}

