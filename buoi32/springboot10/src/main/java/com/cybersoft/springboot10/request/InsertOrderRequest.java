package com.cybersoft.springboot10.request;

import com.cybersoft.springboot10.entity.Products;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InsertOrderRequest {
    private String customerName;
    private List<Integer> productId;

}
