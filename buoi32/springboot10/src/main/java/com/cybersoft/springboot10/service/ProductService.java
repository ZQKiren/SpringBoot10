package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Products;
import com.cybersoft.springboot10.repository.ProductRepository;
import com.cybersoft.springboot10.request.InsertProductRequest;
import com.cybersoft.springboot10.request.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getProduct(){
        return productRepository.findAll();
    }

    public String insertProduct(InsertProductRequest req){
        Products products = new Products();

        products.setName(req.getProductName());
        products.setDescription(req.getProductDesc());
        products.setImagePath(req.getProductImage());
        productRepository.save(products);

        return "Thêm sản phẩm thành công: "+req.getProductName();
    }

    public Optional<Products> detailProduct(int id){

        return productRepository.findById(id);
    }

    public String updateProduct(UpdateProductRequest req){
        Optional<Products> products = productRepository.findById(req.getId());
        if (products.isPresent()){
            Products productEntity = products.get();
            productEntity.setName(req.getProductName());
            productEntity.setDescription(req.getProductDesc());
            productEntity.setImagePath(req.getProductName());

            productRepository.save(productEntity);
        }
        return "Cập nhật sản phẩm thành công!";
    }

    public ResponseEntity<?> deleteProduct(int id){
        Optional<Products> products = productRepository.findById(id);
        if(products.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.ok("Xóa sản phẩm thành công!");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sản phẩm để xóa!");
    }

    /**
     * SELECT * //find
     * FROM roles r
     * WHERE r.id = '' By =>
     *
     * Stream API: Java 8
     */


}
