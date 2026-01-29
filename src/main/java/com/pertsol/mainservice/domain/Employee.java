package com.pertsol.mainservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/*
* Employee entity mapped to MongoDB collection to store employee details
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employee")
public class Employee {
    private String employeeId;
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
}
