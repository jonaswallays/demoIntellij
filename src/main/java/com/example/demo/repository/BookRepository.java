package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("select o from Book o where isbin= :isbin")
    public Book findByIsbin(@Param("isbin") String isbin);
}
