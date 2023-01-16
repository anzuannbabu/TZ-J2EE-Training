package com.pi.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pi.demo.model.Employee;
import com.pi.demo.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository;
	//getting all employee record by using the method findaAll() of jpaRepository
	public List<Employee> getAllEmployee() 
	{
		List<Employee> employee = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(x -> employee.add(x));
		return employee;
	}
	//getting a specific record by using the method findById() of jpaRepository
	public Employee getEmployeeById(long id) 
	{
		return employeeRepository.findById(id).get();
	}
	//saving a specific record by using the method save() of jpaRepository
	public void saveOrUpdate(Employee employee) 
	{
		employeeRepository.save(employee);
	}
	//deleting a specific record by using the method deleteById() of jpaRepository
	public void delete(long id) 
	{
		employeeRepository.deleteById(id);
	}
	//updating a record
	public void update(Employee employee, long employeeId) 
	{
		employeeRepository.save(employee);
	}
}