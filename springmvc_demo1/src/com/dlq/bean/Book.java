package com.dlq.bean;

import lombok.Data;

/**
 *@program: SpringMVC
 *@description:
 *@author: Hasee
 *@create: 2021-01-23 13:03
 */
@Data
public class Book {

    private String name;
    private Integer price;
    private String author;
    private String cat;
}
