package com.yc.snackoverflow.filter;


import com.yc.snackoverflow.service.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
@Order(2)
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER = "Bearer ";


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        log.info("JwtAuthenticationFilter");
        final String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
        final String jwt;
        final String userEmail;
        if (authorizationHeader == null || authorizationHeader.startsWith(BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authorizationHeader.substring(7);
        userEmail = jwtTokenProvider.extractUsername(jwt);
        if (userEmail == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            log.info("Setting security context for user: " + userEmail);
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            if (jwtTokenProvider.isValidateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}