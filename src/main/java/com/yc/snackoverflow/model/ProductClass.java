package com.yc.snackoverflow.model;

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
public class ProductClass extends BaseModel {

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    public ProductClass() {
    }

    public ProductClass(@NotNull String name) {
        this.name = name;
    }
}