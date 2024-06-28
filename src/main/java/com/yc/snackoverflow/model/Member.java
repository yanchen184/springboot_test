package com.yc.snackoverflow.model;

import com.yc.snackoverflow.enums.VipEnum;
import com.yc.snackoverflow.model.baseAbstract.BaseLongIdDO;
import com.yc.snackoverflow.reposity.converter.VipEnumAttrConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MEMBER")
public class Member extends BaseLongIdDO {

    private String name;

    private String password;

    private Boolean alive;

    @Convert(converter = VipEnumAttrConverter.class)
    private VipEnum vip;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "member",
            cascade = {CascadeType.PERSIST}
    )
    private Set<MemberLog> memberLogs;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "member",
            cascade = {CascadeType.PERSIST}
    )
    private Set<ProductCommit> productCommits;


}