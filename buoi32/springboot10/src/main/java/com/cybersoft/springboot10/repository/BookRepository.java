package com.cybersoft.springboot10.repository;

import com.cybersoft.springboot10.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    List<Books> findByAuthor(String author);
}
