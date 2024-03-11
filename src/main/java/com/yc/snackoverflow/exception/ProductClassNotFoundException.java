package com.yc.snackoverflow.exception;

public class ProductClassNotFoundException extends Exception {

    public ProductClassNotFoundException(String msg) {

        super(String.format("ProductClass not found. Product id : [%s]", msg));
    }
}
