package com.yc.snackoverflow.model;

import com.yc.snackoverflow.model.baseAbstract.BaseLongIdDO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product extends BaseLongIdDO {

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "PIC", nullable = false)
    private String pic;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @NotNull
    @Column(name = "DISABLE", nullable = false)
    private boolean disable;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private ProductClass productClass;

    public Product() {
    }

    public Product(@NotNull String name,
                   @NotNull String pic, @NotNull Integer price, @NotNull ProductClass productClass) {
        this.name = name;
        this.pic = pic;
        this.price = price;
        this.productClass = productClass;
        this.disable = false;
    }

}