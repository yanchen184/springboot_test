package com.yc.snackoverflow.service;

import com.yc.snackoverflow.data.auth.AuthenticationRequest;
import com.yc.snackoverflow.data.auth.AuthenticationRes;
import com.yc.snackoverflow.data.auth.RegisterReq;
import com.yc.snackoverflow.enums.Role;
import com.yc.snackoverflow.enums.VipEnum;
import com.yc.snackoverflow.model.Member;
import com.yc.snackoverflow.reposity.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yc
 * @create 2024 - 07 - 23 - 上午 10:41
 */

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final MemberDao memberDao;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthenticationRes register(RegisterReq registerRequsetData) {
        Member member = Member.builder()
                .name(registerRequsetData.getUsername())
                .alive(true)
                .vip(VipEnum.VIP1)
                .email(registerRequsetData.getEmail())
                .password(passwordEncoder.encode(registerRequsetData.getPassword()))
                .role(Role.USER)
                .build();
        memberDao.save(member);

        jwtService.generateToken(member);
        return AuthenticationRes.builder()
                .token(jwtService.generateToken(member))
                .build();
    }

    public AuthenticationRes authenticate(AuthenticationRequest authenticationRequestData) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequestData.getEmail(),
                        authenticationRequestData.getPassword())
        );
        return AuthenticationRes.builder()
                .token(jwtService.generateToken(memberDao.findByEmail(authenticationRequestData.getEmail()).get()))
                .build();
    }
}
