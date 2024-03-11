package com.yc.snackoverflow.service.impl;

import com.yc.snackoverflow.data.BookingData;
import com.yc.snackoverflow.data.BookingDto;
import com.yc.snackoverflow.data.CountBookingReturnData;
import com.yc.snackoverflow.exception.BookingNotFoundException;
import com.yc.snackoverflow.exception.MemberNotFoundException;
import com.yc.snackoverflow.exception.ProductNotFoundException;
import com.yc.snackoverflow.model.Booking;
import com.yc.snackoverflow.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public void createBooking(BookingDto bookingDto) throws MemberNotFoundException, ProductNotFoundException, BookingNotFoundException {

    }

    @Override
    public void updateBooking(BookingDto bookingDto) throws MemberNotFoundException, ProductNotFoundException, BookingNotFoundException {

    }

    @Override
    public List<BookingData> getBookingByMemberNameAndDate(String memberName, Integer date) throws ProductNotFoundException, MemberNotFoundException {
        return null;
    }

    @Override
    public List<Booking> getBookingByDate(Integer date) {
        return null;
    }

    @Override
    public void deleteBooking(BookingDto member) throws ProductNotFoundException {

    }

    @Override
    public List<CountBookingReturnData> countBooking(Integer date, Integer maxPrice) {

        return null;
    }

    @Override
    public List<BookingData> getAllBooking() {
        return null;
    }


}