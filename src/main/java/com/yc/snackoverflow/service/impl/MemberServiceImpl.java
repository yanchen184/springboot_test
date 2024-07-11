package com.yc.snackoverflow.service.impl;

import com.yc.snackoverflow.data.MemberDto;
import com.yc.snackoverflow.enums.UpsertStatusEnum;
import com.yc.snackoverflow.enums.VipEnum;
import com.yc.snackoverflow.exception.WebErrorEnum;
import com.yc.snackoverflow.model.Member;
import com.yc.snackoverflow.reposity.MemberDao;
import com.yc.snackoverflow.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    @Override
    @Transactional
    public UpsertStatusEnum createOrUpdate(MemberDto memberDto) {
        Member member = Member.builder()
                .name(memberDto.getName())
                .alive(true)
                .vip(VipEnum.VIP1)
                .password(memberDto.getPassword())
                .build();
        int createOrUpdate = memberDao.saveOrUpdate(member);

        log.info("memberDao.saveOrUpdateMember(member) return {}", UpsertStatusEnum.lookup(createOrUpdate));
        return UpsertStatusEnum.lookup(createOrUpdate)
                .orElseThrow(WebErrorEnum.UPSERT_FAILED::exception);
    }

    @Override
    public List<Member> list(List<String> memberNameList) {
        return Optional.ofNullable(memberDao.list(memberNameList))
                .filter(members -> !members.isEmpty())
                .orElseThrow(WebErrorEnum.MEMBER_NOT_FOUND::exception);
    }
}