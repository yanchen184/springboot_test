package com.yc.snackoverflow.data;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Data
public class BookingDto {

    private String memberName;

    private Integer month;

    private List<BookingDtoDetail> bookingDtoDetailList;
}
