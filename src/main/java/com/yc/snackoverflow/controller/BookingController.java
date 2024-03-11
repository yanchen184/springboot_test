package com.yc.snackoverflow.controller;


import com.yc.snackoverflow.data.BookingData;
import com.yc.snackoverflow.data.BookingDto;
import com.yc.snackoverflow.data.CountBookingReturnData;
import com.yc.snackoverflow.exception.BookingNotFoundException;
import com.yc.snackoverflow.exception.MemberNotFoundException;
import com.yc.snackoverflow.exception.ProductNotFoundException;
import com.yc.snackoverflow.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {


    private final BookingService bookingService;

    @PutMapping
    public void createBooking(@RequestBody BookingDto bookingDto) throws MemberNotFoundException, ProductNotFoundException, BookingNotFoundException {
        bookingService.createBooking(bookingDto);
    }

    @PostMapping
    public void updateBooking(@RequestBody BookingDto bookingDto) throws ProductNotFoundException, BookingNotFoundException, MemberNotFoundException {
        bookingService.createBooking(bookingDto);
    }

    @GetMapping
    public List<BookingData> getBooking(String member, Integer month) throws ProductNotFoundException, MemberNotFoundException {
        return bookingService.getBookingByMemberNameAndDate(member, month);
    }

    @DeleteMapping
    public void deleteBooking(@RequestBody BookingDto bookingDto) throws ProductNotFoundException {
        bookingService.deleteBooking(bookingDto);
    }

    @GetMapping("/count")
    public List<CountBookingReturnData> countBooking(Integer month, Integer maxPrice) {
        return bookingService.countBooking(month, maxPrice);
    }

    @GetMapping("/all")
    public List<BookingData> getAllBooking() {
        return bookingService.getAllBooking();
    }

}
