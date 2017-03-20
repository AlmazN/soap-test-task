package com.almazn.soap.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private int id;

  @Column(name = "Firstname", length = 50, nullable = false)
  private String firstName;

  @Column(name = "Lastname", length = 50, nullable = false)
  private String lastName;

  @Column(name = "Middlename", length = 50)
  private String middleName;

  @Column(name = "Gender", nullable = false)
  private Gender gender;

  @Column(name = "DriverLicense", length = 20)
  private String driverLicense;

  @Column(name = "DepartmentId", nullable = false)
  private int departmentId;

  public Employee() {
  }

  public Employee(String firstName, String lastName, String middleName, Gender gender, String driverLicense, int departmentId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.gender = gender;
    this.driverLicense = driverLicense;
    this.departmentId = departmentId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getDriverLicense() {
    return driverLicense;
  }

  public void setDriverLicense(String driverLicense) {
    this.driverLicense = driverLicense;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", middleName='" + middleName + '\'' +
            ", gender='" + gender + '\'' +
            ", driverLicense='" + driverLicense + '\'' +
            '}';
  }
}
