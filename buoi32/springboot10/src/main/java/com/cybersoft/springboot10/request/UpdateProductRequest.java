package com.cybersoft.springboot10.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {
    private int id;
    private String productName;
    private String productDesc;
    private String productImage;

}
