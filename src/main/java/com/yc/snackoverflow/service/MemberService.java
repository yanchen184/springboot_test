package com.yc.snackoverflow.service;

import com.yc.snackoverflow.data.MemberDto;
import com.yc.snackoverflow.enums.UpsertStatusEnum;
import com.yc.snackoverflow.model.Member;

import java.util.List;

public interface MemberService {
    UpsertStatusEnum createOrUpdate(MemberDto MemberDto);

    List<Member> list(List<String> memberList);

}
