package com.avi.webflux6.stocktrading.model;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Document("department")
public class Department {
	private String id;	
	private String name;
	
	 @DocumentReference(lazy = true, lookup = "{ 'name' : ?#{#self.id} }")
	    @ReadOnlyProperty
	    private Employee emp;
	
//	 @DocumentReference(lazy = true)
//	 private Employee emp;
	 
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
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
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
