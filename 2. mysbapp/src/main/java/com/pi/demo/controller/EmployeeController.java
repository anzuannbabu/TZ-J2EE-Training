package com.pi.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pi.demo.model.Employee;
import com.pi.demo.repository.DepartmentRepository;
import com.pi.demo.repository.EmployeeRepository;
import com.pi.demo.service.DepartmentService;
import com.pi.demo.service.EmployeeService;

//mark class as Controller
@RestController
public class EmployeeController 
{
	//autowire the EmployeeService class
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;
	
	//creating a get mapping that retrieves all the employee detail from the database 
	//@GetMapping("/emp") //This is default, default response is JSON
	@RequestMapping (
		value = "/emp",
		method = RequestMethod.GET,
		produces = "application/json"
	)
	@ResponseBody
	private List<Employee> getAllEmployee() 
	{
		return employeeService.getAllEmployee();
	}

	//creating a get mapping that retrieves the detail of a specific employee
	//@GetMapping("/emp/{employeeid}")
	@RequestMapping (
			value = "/emp/{employeeid}",
			method = RequestMethod.GET,
			produces = "application/json"
	)
	private Employee getEmployee(@PathVariable("employeeid") long employeeid) 
	{
		return employeeService.getEmployeeById(employeeid);
	}
	
	//creating a delete mapping that deletes a specified employee
	@DeleteMapping("/emp/{employeeid}")
	private void deleteEmployee(@PathVariable("employeeid") long employeeid) 
	{
		employeeService.delete(employeeid);
	}

	//creating post mapping that post the employee detail in the database
	//@PostMapping("/emp")
	@RequestMapping (
			value = "/emp/{deptId}",
			method = RequestMethod.POST,
			produces = "application/json"
	)
	private long saveEmployee(@PathVariable(value = "deptId") long deptId , @RequestBody Employee employee) 
	{
		employee.setDepartment(departmentRepository.findById(deptId).get());
		return employeeRepository.save(employee).getEmpId();
		
	}
	/*//old implementation
	private long saveEmployee(@RequestBody Employee employee) 
	{
		employeeService.saveOrUpdate(employee);
		return employee.getId();
	}*/
	//creating put mapping that updates the employee detail 
	@PutMapping("/emp")
	private Employee updateEmployee(@RequestBody Employee employee) 
	{
		employeeService.saveOrUpdate(employee);
		return employee;
	}
}
