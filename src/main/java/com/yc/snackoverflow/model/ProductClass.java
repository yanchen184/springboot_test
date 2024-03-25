package com.yc.snackoverflow.model;

import com.yc.snackoverflow.model.baseAbstract.BaseLongIdDO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Getter
@Setter
@Table(name = "PRODUCT_CLASS")
public class ProductClass extends BaseLongIdDO {

    @Column(name = "member_id", nullable = false)
    private Member member;

    public ProductClass() {
    }
}