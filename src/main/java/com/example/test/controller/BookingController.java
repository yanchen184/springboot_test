package com.example.test.controller;


import com.example.test.data.ColorDto;
import com.example.test.service.CmsColorService;
import com.example.test.color.CmsColorMainResponseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/save_Color")
    public void saveColor(@RequestBody ColorDto colorDto) {
         cmsColorService.saveColor(colorDto);
    }

}
