package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userid;
    private String username;
    private String password;
    private Integer sex;
    private String idCard;
    private String phoneNumber;
    private Integer balance;//余额
}
