package com.pertsol.mainservice.controller;

import com.pertsol.mainservice.domain.Employee;
import com.pertsol.mainservice.dto.request.CreateEmployeeRequest;
import com.pertsol.mainservice.dto.request.FieldRequest;
import com.pertsol.mainservice.dto.response.ApiResponse;
import com.pertsol.mainservice.service.EmployeeService;
import com.pertsol.mainservice.util.AppConstants;
import com.pertsol.mainservice.util.Endpoints;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
* Controller layer handles HTTP requests and delegates business logic to the service layer while returning a standard API response.
*/
@Slf4j
@RestController
@RequestMapping("/v1/employee")  // This is the Base URL for employee APIs
public class EmployeeController {

    private final EmployeeService employeeService;

    // Injecting EmployeeService
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // This API will create new Employee Record
    @PostMapping(value = Endpoints.CREATE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeRequest request) {
        try {
            ApiResponse<Employee> response = employeeService.createEmployee(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            log.info("Create Employee Record Exception: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    // This API will fetch employee data based on requested fields
    @GetMapping(value = Endpoints.FETCH_EMPLOYEE_DATA, produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<Map<String, Object>>>> fetchEmployee(@RequestBody FieldRequest request) {
        try {
           List<Map<String, Object>> response = employeeService.fetchEmployeeData(request.getFields());
            return ResponseEntity.ok(new ApiResponse<>(AppConstants.SUCCESS, "Employee Data Fetched Successfully",
                    HttpStatus.OK.value(), response));
        } catch (Exception e) {
            log.info("Exception in Fetching Employee Record: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
