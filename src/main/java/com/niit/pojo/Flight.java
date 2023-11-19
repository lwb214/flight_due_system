package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private Integer planeId;
    private String model;
    private String companyName;
    private Integer price;
    private Integer remainSeats;
}
