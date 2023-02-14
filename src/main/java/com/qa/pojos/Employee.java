package com.qa.pojos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
public class Employee {

    private long id;
    private String fName;
    private String lName;
    private String city;
}
