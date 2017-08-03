package com.bookdatabaseannajad.demo.Repositories;


import com.bookdatabaseannajad.demo.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {


}
