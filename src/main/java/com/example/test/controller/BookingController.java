package com.example.test.controller;


import com.example.test.service.CmsColorService;
import data.color.CmsColorMainResponseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class BookingController {

    private final CmsColorService cmsColorService;

    @GetMapping("/hello")
    public String createBooking() {
        log.info("hello world");
        return "hello world";
    }

    @GetMapping("/get_Color")
    public List<CmsColorMainResponseData> getAllColor() {
        return cmsColorService.getAllColor();
    }

}
