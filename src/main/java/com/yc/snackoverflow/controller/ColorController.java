package com.yc.snackoverflow.controller;


import com.yc.snackoverflow.data.ColorCustomResponseData;
import com.yc.snackoverflow.data.ColorRequestData;
import com.yc.snackoverflow.service.ColorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/colors")
public class ColorController {

    private final ColorService colorService;

    @GetMapping
    public List<ColorCustomResponseData> listMember() {
        return colorService.getColor();
    }

    @PutMapping
    public void saveColor(ColorRequestData colorRequestData) {
        colorService.saveColor(colorRequestData);
    }

}