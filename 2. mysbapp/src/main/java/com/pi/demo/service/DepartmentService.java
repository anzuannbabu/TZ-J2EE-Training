package com.pi.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pi.demo.model.Department;
import com.pi.demo.repository.DepartmentRepository;

@Service
public class DepartmentService 
{
	@Autowired
	DepartmentRepository departmentRepository;
	//getting all department record by using the method findaAll() of jpaRepository
	public List<Department> getAllDepartment() 
	{
		//List<Department> department = new ArrayList<Department>();
		//departmentRepository.findAll().forEach(x -> department.add(x));
		//List<Department> department = departmentRepository.findAll()
		return departmentRepository.findAll();
	}
	//getting a specific record by using the method findById() of jpaRepository
	public Department getDepartmentById(long id) 
	{
		return departmentRepository.findById(id).get();
	}
	//saving a specific record by using the method save() of jpaRepository
	public void saveOrUpdate(Department department) 
	{
		departmentRepository.save(department);
	}
	//deleting a specific record by using the method deleteById() of jpaRepository
	public void delete(long id) 
	{
		departmentRepository.deleteById(id);
	}
	//updating a record
	public void update(Department department, long deptId) 
	{
		departmentRepository.save(department);
	}
}