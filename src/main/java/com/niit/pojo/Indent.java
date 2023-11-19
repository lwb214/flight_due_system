package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Indent {
    private Integer id;//订单id
    private Integer planeId;
    private String username;
    private String phone;
    private Integer coach;//01
    private Integer price;
    private Integer SeatId;
    private Integer state;//012
}
