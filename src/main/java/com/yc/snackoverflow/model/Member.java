package com.yc.snackoverflow.model;

import com.yc.snackoverflow.model.baseAbstract.BaseLongIdDO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "MEMBER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseLongIdDO {

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

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "member",
            cascade = {CascadeType.PERSIST}
    )
    private Set<LoginLog> LoginLogs;

}