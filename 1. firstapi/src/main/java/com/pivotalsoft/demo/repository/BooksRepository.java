package com.pivotalsoft.demo.repository;
import org.springframework.data.repository.CrudRepository;
//repository that extends CrudRepository
import com.pivotalsoft.demo.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
