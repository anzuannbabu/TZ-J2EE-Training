package com.pivotalsoft.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
	@Autowired
	UserRepository userRepository;
	//getting all department record by using the method findaAll() of jpaRepository
	public List<User> getAllUser() 
	{
		return (List<User>) userRepository.findAll();
	}
	//getting a specific record by using the method findById() of jpaRepository
	public User getUserById(long id) 
	{
		return userRepository.findById(id).get();
	}
	//saving a specific record by using the method save() of jpaRepository
	public void saveOrUpdate(User user) 
	{
		userRepository.save(user);
	}
	//deleting a specific record by using the method deleteById() of jpaRepository
	public void delete(long id) 
	{
		userRepository.deleteById(id);
	}
	//updating a record
	public void update(User user, long deptId) 
	{
		userRepository.save(user);
	}
}