package com.pivotalsoft.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//mark class as Controller
@RestController
public class EmployeeController 
{
	//autowire the EmployeeService class
	@Autowired
	EmployeeMyBatisService employeeService;
	
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
			value = "/emp",
			method = RequestMethod.POST,
			produces = "application/json"
	)
	private long saveEmployee(@RequestBody Employee employee) 
	{
		employeeService.save(employee);
		return employee.getId();
	}
	@PutMapping("/emp")
	private Employee updateEmployee(@RequestBody Employee employee) 
	{
		employeeService.update(employee);
		return employee;
	}
}
