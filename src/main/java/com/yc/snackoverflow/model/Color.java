package com.yc.snackoverflow.model;

import com.yc.snackoverflow.model.baseAbstract.BaseLongIdDO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "color")
public class Color extends BaseLongIdDO {
    private String code;
    private String zhName;
    private String enName;
}
