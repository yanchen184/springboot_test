package com.yc.snackoverflow.exception;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String msg) {

        super(String.format("Product not found. Product name : [%s]", msg));
    }
}
