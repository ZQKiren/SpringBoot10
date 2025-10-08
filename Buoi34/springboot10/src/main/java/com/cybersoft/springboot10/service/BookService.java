package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Books;

import java.util.List;

public interface BookService {
    List<Books> searchBook(String author);

    List<Books> filterPrice(int minPrice, int maxPrice);
}
