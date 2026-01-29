package com.pertsol.mainservice.dto.request;

import lombok.Data;

/*
* Request DTO used to accept employee details while creating an employee
 */
@Data
public class CreateEmployeeRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String dateOfBirth;
    private String city;
    private String state;
    private String country;
    private String gender;
    private String department;
    private String maritalStatus;
    private String aadhaarNumber;
    private String panNumber;
    private String position;
    private String employeeId;
}
