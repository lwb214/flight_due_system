package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    private Integer id;
    private String startPlace;
    private Date startTime;
    private String endPlace;
    private Date endTime;
    private Integer seatNumber;
    private Float totalTime;
}
