package com.yc.snackoverflow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@Table(name = "MEMBER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseModel {

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "ALIVE", nullable = false)
    private boolean alive;

    @NotNull
    @Column(name = "VIP", nullable = false)
    private Integer vip;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

}