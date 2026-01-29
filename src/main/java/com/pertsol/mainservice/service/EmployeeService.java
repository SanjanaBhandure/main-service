package com.pertsol.mainservice.service;

import com.pertsol.mainservice.domain.Employee;
import com.pertsol.mainservice.dto.request.CreateEmployeeRequest;
import com.pertsol.mainservice.dto.response.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
*  Interface is used to provide abstraction and separate business logic from implementation.
 */
@Service
public interface EmployeeService {
    ApiResponse<Employee> createEmployee(CreateEmployeeRequest request);

    List<Map<String, Object>> fetchEmployeeData(List<String> requestedFields);

}
