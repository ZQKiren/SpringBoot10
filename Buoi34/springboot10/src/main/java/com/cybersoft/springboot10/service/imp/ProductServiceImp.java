package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.entity.Products;
import com.cybersoft.springboot10.repository.ProductRepository;
import com.cybersoft.springboot10.request.InsertProductRequest;
import com.cybersoft.springboot10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Products> getAll(){
        return productRepository.findAll();
    }

    @Override
    public String addProduct(InsertProductRequest req){

        Products products = new Products();
        products.setName(req.getProductName());
        products.setPrice(req.getProductPrice());

        productRepository.save(products);

        return "Thêm sản phẩm thành công! "+ products.getName();
    }

    @Override
    public String updateProduct(int productId, InsertProductRequest req){
        Optional<Products> products = productRepository.findById(productId);
        if(products.isPresent()){
            Products productEntity = products.get();
            productEntity.setName(req.getProductName());
            productEntity.setPrice(req.getProductPrice());

            productRepository.save(productEntity);
        }

        return "Cập nhật sản phẩm thành công!";
    }

    @Override
    public Optional<Products> detailProduct(int id){
        return productRepository.findById(id);
    }

    @Override
    public ResponseEntity<?> deleteProduct(int id){
        Optional<Products> products = productRepository.findById(id);
        if (products.isPresent()){
            Products productEntity = products.get();
            productRepository.delete(productEntity);
            return ResponseEntity.ok("Xóa sản phẩm thành công!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sản phẩm cần xóa!");
        }

    }
}
