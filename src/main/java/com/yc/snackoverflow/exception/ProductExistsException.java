package com.yc.snackoverflow.exception;

public class ProductExistsException extends Exception {

    public ProductExistsException(String msg){

        super(String.format("Product Exists . Product name : [%s]", msg));
    }
}
