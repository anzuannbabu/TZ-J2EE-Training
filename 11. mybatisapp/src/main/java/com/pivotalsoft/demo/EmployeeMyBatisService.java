package com.pivotalsoft.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMyBatisService 
{
	@Autowired
	EmployeeMyBatisRepository employeeRepository;
	//getting all employee record by using the method findaAll() of jpaRepository
	public List<Employee> getAllEmployee() 
	{
		return employeeRepository.findAll();
	}
	//getting a specific record by using the method findById() of jpaRepository
	public Employee getEmployeeById(long id) 
	{
		return employeeRepository.findById(id);
	}
	//saving a specific record by using the method save() of jpaRepository
	public void save(Employee employee) 
	{
		employeeRepository.insert(employee);
	}
	//deleting a specific record by using the method deleteById() of jpaRepository
	public void delete(long id) 
	{
		employeeRepository.deleteById(id);
	}
	//updating a record
	public void update(Employee employee) 
	{
		employeeRepository.update(employee);
	}
}