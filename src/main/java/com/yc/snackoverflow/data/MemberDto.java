package com.yc.snackoverflow.data;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Data
public class MemberDto {

    @NonNull
    private String name;

    @NonNull
    private String password;

}
