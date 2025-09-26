package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Books;
import com.cybersoft.springboot10.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Books> searchBook(String author){
        return bookRepository.findByAuthor(author);
    }
}
