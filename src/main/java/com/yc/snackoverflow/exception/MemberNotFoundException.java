package com.yc.snackoverflow.exception;

public class MemberNotFoundException extends Exception {

    public MemberNotFoundException(String msg){

        super(String.format("Member not found. Member name : [%s]", msg));
    }
}
