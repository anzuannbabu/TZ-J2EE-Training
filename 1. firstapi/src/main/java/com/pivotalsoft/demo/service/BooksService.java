package com.pivotalsoft.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pivotalsoft.demo.model.Books;
import com.pivotalsoft.demo.repository.BooksRepository;
//defining the business logic
@Service
public class BooksService 
{
	@Autowired
	BooksRepository booksRepository;
	//getting all books record by using the method findaAll() of CrudRepository
	public List<Books> getAllBooks() 
	{
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(x -> books.add(x));
		return books;
	}
	//getting a specific record by using the method findById() of CrudRepository
	public Books getBooksById(int id) 
	{
		Optional<Books> b1 = booksRepository.findById(id);
		if(b1.isEmpty())
		{
			return null;
		}
		return b1.get();
	}
	//saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Books books) 
	{
		booksRepository.save(books);
	}
	//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) 
	{
		Optional<Books> b1 = booksRepository.findById(id);
		if(!b1.isEmpty())
		{
			booksRepository.deleteById(id);
		}
	}
	//updating a record
	public void update(Books books, int bookid) 
	{
		booksRepository.save(books);
	}
}