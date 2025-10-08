package com.cybersoft.springboot10.repository;

import com.cybersoft.springboot10.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findByCategoryId(int categoryId);
}
