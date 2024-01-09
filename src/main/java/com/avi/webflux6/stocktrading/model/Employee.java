package com.avi.webflux6.stocktrading.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.bind.annotation.Mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Document("employee")
public class Employee {
	private String id;
	private String name;	
	private int salary;
	private String department;
	
//	@Field("deptname") @DocumentReference(lazy = true,lookup = "{'name' : ?#{#self._id}}") 
//	private Department dname;
	
	@DocumentReference
    private Department dname;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Department getDname() {
		return dname;
	}
	public void setDname(Department dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", dname=" + dname + "]";
	}
	
}
