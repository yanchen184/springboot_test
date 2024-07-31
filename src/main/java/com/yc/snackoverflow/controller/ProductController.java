package com.yc.snackoverflow.controller;


import com.yc.snackoverflow.data.BookingDto;
import com.yc.snackoverflow.data.ProductDto;
import com.yc.snackoverflow.enums.UpsertStatusEnum;
import com.yc.snackoverflow.model.Product;
import com.yc.snackoverflow.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {


    private final ProductService productService;

    @PutMapping
    public UpsertStatusEnum create(@Validated @RequestBody ProductDto productDto) {
        return productService.createOrUpdate(productDto);
    }

    @PostMapping
    public UpsertStatusEnum update(@RequestBody ProductDto productDto) {
        return productService.createOrUpdate(productDto);
    }

    @GetMapping
    public List<Product> list(@RequestParam(required = false) List<String> memberNameList) {
        return productService.list(memberNameList);
    }

    @DeleteMapping
    public void delete(@RequestBody BookingDto bookingDto) {
//        memberService.deleteBooking(bookingDto);
    }
}
