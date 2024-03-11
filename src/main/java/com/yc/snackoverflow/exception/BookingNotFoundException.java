package com.yc.snackoverflow.exception;

public class BookingNotFoundException extends Exception {

    public BookingNotFoundException(String msg, String msg1) {

        super(String.format("Booking not found. Member  : [%s] , product : [%s]", msg, msg1));
    }
}
