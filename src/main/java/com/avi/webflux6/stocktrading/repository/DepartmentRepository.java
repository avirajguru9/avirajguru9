package com.avi.webflux6.stocktrading.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avi.webflux6.stocktrading.model.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String>  {

}
