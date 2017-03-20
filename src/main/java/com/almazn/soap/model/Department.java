package com.almazn.soap.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Department")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "Id")
  private int id;

  @Column(name = "Name", length = 100, nullable = false)
  private String name;

  @JoinColumn(name = "ParentId")
  @ManyToOne(cascade = {CascadeType.ALL})
  private Department parent;

  @OneToMany(mappedBy = "parent")
  private Set<Department> children = new HashSet<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Department getParent() {
    return parent;
  }

  public void setParent(Department parent) {
    this.parent = parent;
  }

  public Set<Department> getChildren() {
    return children;
  }

  public void setChildren(Set<Department> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Department that = (Department) o;

    return id == that.id;
  }

  @Override
  public int hashCode() {
    return id;
  }
}
