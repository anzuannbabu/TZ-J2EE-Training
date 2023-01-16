package com.pi.demo.controller;
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

import com.pi.demo.model.Department;
import com.pi.demo.service.DepartmentService;

//mark class as Controller
@RestController
public class DepartmentController 
{
	//autowire the DepartmentService class
	@Autowired
	DepartmentService departmentService;

	//creating a get mapping that retrieves all the department detail from the database 
	//@GetMapping("/dept") //This is default, default response is JSON
	@RequestMapping (
		value = "/dept",
		method = RequestMethod.GET,
		produces = "application/json"
	)
	@ResponseBody
	private List<Department> getAllDepartment() 
	{
		return departmentService.getAllDepartment();
	}

	//creating a get mapping that retrieves the detail of a specific department
	//@GetMapping("/dept/{departmentid}")
	@RequestMapping (
			value = "/dept/{departmentid}",
			method = RequestMethod.GET,
			produces = "application/json"
	)
	private Department getDepartment(@PathVariable("departmentid") long departmentid) 
	{
		return departmentService.getDepartmentById(departmentid);
	}
	
	//creating a delete mapping that deletes a specified department
	@DeleteMapping("/dept/{departmentid}")
	private void deleteBook(@PathVariable("departmentid") long departmentid) 
	{
		departmentService.delete(departmentid);
	}

	//creating post mapping that post the department detail in the database
	//@PostMapping("/dept")
	@RequestMapping (
			value = "/dept",
			method = RequestMethod.POST,
			produces = "application/json"
	)
	private long saveBook(@RequestBody Department department) 
	{
		departmentService.saveOrUpdate(department);
		return department.getDeptId();
	}
	//creating put mapping that updates the department detail 
	@PutMapping("/dept")
	private Department update(@RequestBody Department department) 
	{
		departmentService.saveOrUpdate(department);
		return department;
	}
}
