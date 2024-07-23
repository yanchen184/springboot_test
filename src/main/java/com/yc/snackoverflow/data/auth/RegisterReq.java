package com.yc.snackoverflow.data.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yc
 * @create 2024 - 07 - 23 - 上午 10:39
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReq {
    private String username;
    private String password;
    private String email;
}
