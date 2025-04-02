package com.hust.demo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {// nhập không dấu
    private String name; // không ký tự đặc biệt, số, tối thiểu 10 ký tự, tối đa 100 (regex [^a-zA-Z])
    private int age;
    private String dob; // là ngày hợp lệ, age và dob phải khớp
    private String address; // tối thiểu 50, tối đa 500
    private String phoneNumber; // 10 ký tự, là số, bắt đầu bằng 0 regex
    private String email; // phải là email regex (có chứa @, k có kí tự đặc biệt
    private String gender; // nam/nữ
    private String idNumber; // là số, dài 12 ký tự regex
    private String issueDate; // là ngày hợp lệ
    private String issuePlace; // tối thiểu 50, tối đa 500, không có ký tự đặc biệt regex
}
