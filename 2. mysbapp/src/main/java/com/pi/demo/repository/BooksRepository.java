package com.pi.demo.repository;
import org.springframework.data.repository.CrudRepository;
//repository that extends CrudRepository
import com.pi.demo.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
