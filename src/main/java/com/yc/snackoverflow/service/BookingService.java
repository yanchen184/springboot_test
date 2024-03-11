package com.yc.snackoverflow.service;

import com.yc.snackoverflow.data.BookingData;
import com.yc.snackoverflow.data.BookingDto;
import com.yc.snackoverflow.data.CountBookingReturnData;
import com.yc.snackoverflow.exception.BookingNotFoundException;
import com.yc.snackoverflow.exception.MemberNotFoundException;
import com.yc.snackoverflow.exception.ProductNotFoundException;
import com.yc.snackoverflow.model.Booking;

import java.util.List;

public interface BookingService {
    void createBooking(BookingDto bookingDto) throws MemberNotFoundException, ProductNotFoundException, BookingNotFoundException;

    void updateBooking(BookingDto bookingDto) throws MemberNotFoundException, ProductNotFoundException, BookingNotFoundException;

    List<BookingData> getBookingByMemberNameAndDate(String memberName, Integer date) throws ProductNotFoundException, MemberNotFoundException;

    List<Booking> getBookingByDate(Integer date);

    void deleteBooking(BookingDto member) throws ProductNotFoundException;

    List<CountBookingReturnData> countBooking(Integer date, Integer maxPrice);

    List<BookingData> getAllBooking();
}
