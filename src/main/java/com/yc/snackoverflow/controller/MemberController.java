package com.yc.snackoverflow.controller;


import com.yc.snackoverflow.data.BookingDto;
import com.yc.snackoverflow.data.MemberDto;
import com.yc.snackoverflow.enums.UpsertStatusEnum;
import com.yc.snackoverflow.exception.ProductNotFoundException;
import com.yc.snackoverflow.model.Member;
import com.yc.snackoverflow.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/members")
public class MemberController {


    private final MemberService memberService;

    @PutMapping
    public UpsertStatusEnum create(@Validated @RequestBody MemberDto memberDto) {
        return memberService.createOrUpdateMember(memberDto);
    }

    @PostMapping
    public UpsertStatusEnum update(@RequestBody MemberDto memberDto) {
        return memberService.createOrUpdateMember(memberDto);
    }

    @GetMapping
    public List<Member> listMember(List<String> memberNameList) {
        return memberService.listMember(memberNameList);
    }

    @DeleteMapping
    public void delete(@RequestBody BookingDto bookingDto) throws ProductNotFoundException {
//        memberService.deleteBooking(bookingDto);
    }
}
