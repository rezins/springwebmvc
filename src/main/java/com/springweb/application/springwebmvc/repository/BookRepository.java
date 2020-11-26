package com.springweb.application.springwebmvc.repository;

import com.springweb.application.springwebmvc.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> { }
