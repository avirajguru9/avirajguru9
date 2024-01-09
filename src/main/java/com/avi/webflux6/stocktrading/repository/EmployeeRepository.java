package com.avi.webflux6.stocktrading.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avi.webflux6.stocktrading.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
