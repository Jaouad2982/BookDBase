package com.bookdatabaseannajad.demo.controllers;

import com.bookdatabaseannajad.demo.models.Book;
import com.bookdatabaseannajad.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Iterator;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public String showPage(Model model){

        String myMsg = "Welcome to my page ";
        model.addAttribute("message" , myMsg);
        return "page";
    }


    @GetMapping("/addBooks")
    public String addBooks(Model model){

        model.addAttribute("newBook",new Book());
        return "addBooks";
    }


    @PostMapping("/addBooks")
    public String showBooks(@Valid @ModelAttribute ("newBook") Book book , BindingResult bindingResult){

        if(bindingResult.hasErrors() ){
        return "addBooks";
        }
        bookRepository.save(book);
        return "resultBooks";
    }


    @GetMapping("/showAllBooks")
    public String showmyBooks(Model model){



        Iterable<Book> myList = bookRepository.findAll();
        model.addAttribute("newBook" , myList);
        return "showAllBooks";
    }



}
