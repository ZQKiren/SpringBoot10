package com.cybersoft.springboot10.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertProductRequest {
    private String productName;
    private String productDesc;
    private String ProductImage;

}
