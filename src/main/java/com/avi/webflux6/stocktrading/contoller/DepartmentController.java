package com.avi.webflux6.stocktrading.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avi.webflux6.stocktrading.repository.DepartmentRepository;
import com.avi.webflux6.stocktrading.entity.Department;

@RestController
@RequestMapping("/depart")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departRepo;
	
	@PostMapping("adddepartment")
	public Object addDepartment(@RequestBody Department department) {
		return departRepo.save(department);
	}
	
	@GetMapping("getalldepartment")
	public List<Department> getAllDepartment(){
		return departRepo.findAll();
	}
}
