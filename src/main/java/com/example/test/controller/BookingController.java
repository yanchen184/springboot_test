package com.example.test.controller;


import com.example.test.data.ColorCustomResponseData;
import com.example.test.data.ColorRequestData;
import com.example.test.service.CmsColorService;
import com.example.test.data.ColorResponseData;
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
    public List<ColorResponseData> getAllColor() {
        return cmsColorService.getAllColor();
    }

    @GetMapping("/get_custom_color")
    public List<ColorCustomResponseData> getColor() {
        return cmsColorService.getColor();
    }



    @GetMapping("/save_Color")
    public void saveColor(@RequestBody ColorRequestData colorRequestData) {
         cmsColorService.saveColor(colorRequestData);
    }

}
