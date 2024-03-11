package com.yc.snackoverflow.exception;

public class MemberExistsException extends Exception {

    public MemberExistsException(String msg){

        super(String.format("Member Exists . Member name : [%s]", msg));
    }
}
