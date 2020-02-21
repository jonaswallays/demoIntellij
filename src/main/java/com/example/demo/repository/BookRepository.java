package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {
}
