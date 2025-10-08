package com.cybersoft.springboot10.repository;

import com.cybersoft.springboot10.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {
    List<Books> findByAuthor(String author);

    List<Books> findByPriceBetween(int minPrice, int maxPrice);
}
