package com.hust.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse {
    private int code;// 1 success | 0 fail
    private String msg;
    private String province;
    private String gender;
    private String yob;
}
