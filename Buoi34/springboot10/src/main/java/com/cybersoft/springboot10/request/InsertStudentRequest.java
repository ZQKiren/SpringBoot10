package com.cybersoft.springboot10.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertStudentRequest {
    private String studentName;
    private String studentEmail;
}
