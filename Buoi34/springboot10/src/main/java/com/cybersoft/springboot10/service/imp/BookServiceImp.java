package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.entity.Books;
import com.cybersoft.springboot10.repository.BookRepository;
import com.cybersoft.springboot10.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Books> searchBook(String author){
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Books> filterPrice(int minPrice, int maxPrice){
        return bookRepository.findByPriceBetween(minPrice,maxPrice);
    }

}
