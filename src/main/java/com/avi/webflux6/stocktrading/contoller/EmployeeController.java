package com.avi.webflux6.stocktrading.contoller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.avi.webflux6.stocktrading.model.Employee;
import com.avi.webflux6.stocktrading.model.Stock;
import com.avi.webflux6.stocktrading.repository.DepartmentRepository;
import com.avi.webflux6.stocktrading.repository.EmployeeRepository;
import com.avi.webflux6.stocktrading.repository.StockRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@PostMapping("/addemployee")
	public Object addEmployee(@RequestBody Employee emp){
		Employee save = this.empRepo.save(emp);
		return save.getId();
	}
	
	@GetMapping("/getallemployee")
	public List<Employee> getEmployeDeptWise(@PathVariable String id) {
		return empRepo.findAll();
	}
	
	@GetMapping("/getempbydept")
	public List<Employee> getEmpByDept() {
		List<Employee> allEmp = empRepo.findAll();
		List<String> custList = new ArrayList<>();
		custList.add("");
//		allEmp.stream().map();
		List<Employee> sortedAllEmp = allEmp.stream().sorted(Comparator.comparing(Employee::getDepartment, Comparator.reverseOrder())
				.thenComparing(Employee::getSalary, Comparator.reverseOrder())				
				).collect(Collectors.toList());
		return sortedAllEmp;
	}
}

