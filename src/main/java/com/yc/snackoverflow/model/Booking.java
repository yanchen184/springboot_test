package com.yc.snackoverflow.model;


import com.yc.snackoverflow.model.baseAbstract.BaseLongIdDO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BOOKING")
public class Booking extends BaseLongIdDO {

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Product product;

    @NotNull
    @Column(name = "COUNT", nullable = false)
    private Integer count;

    @NotNull
    @Column(name = "MONTH", nullable = false)
    private Integer month;

    @NotNull
    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    @NotNull
    @Column(name = "DISABLE", nullable = false)
    private boolean disable;

    public Booking(@NotNull Member member, @NotNull Product product, @NotNull Integer count, @NotNull Integer month, @NotNull Integer priority) {
        this.member = member;
        this.product = product;
        this.count = count;
        this.month = month;
        this.priority = priority;
        this.disable = false;
    }

}