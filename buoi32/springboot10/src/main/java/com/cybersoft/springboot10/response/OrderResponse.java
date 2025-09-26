package com.cybersoft.springboot10.response;

import com.cybersoft.springboot10.entity.Products;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private int id;
    private String custumerName;
    private List<Products> products;
}
