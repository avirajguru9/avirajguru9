package com.avi.webflux6.stocktrading.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.avi.webflux6.stocktrading.entity.Employee;
import com.avi.webflux6.stocktrading.entity.Stock;
import com.avi.webflux6.stocktrading.repository.EmployeeRepository;
import com.avi.webflux6.stocktrading.repository.StockRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController{

	@Autowired
	private EmployeeRepository empRepo;
	
	@PostMapping("/addemployee")
	public Object addEmployee(@RequestBody Employee emp){
		Employee save = this.empRepo.save(emp);
		return save.getId();
	}
	
	@GetMapping("/getemployee")
	public List<Employee> getEmployeDeptWise(@PathVariable String id) {
		return empRepo.findAll();
	}
}

