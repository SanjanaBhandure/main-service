package com.pertsol.mainservice.serviceImplementation;

import com.pertsol.mainservice.domain.Employee;
import com.pertsol.mainservice.dto.request.CreateEmployeeRequest;
import com.pertsol.mainservice.dto.response.ApiResponse;
import com.pertsol.mainservice.service.EmployeeService;
import com.pertsol.mainservice.util.AppConstants;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ApiResponse<Employee> createEmployee(CreateEmployeeRequest request) {

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setAddress(request.getAddress());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setCity(request.getCity());
        employee.setState(request.getState());
        employee.setCountry(request.getCountry());
        employee.setMaritalStatus(request.getMaritalStatus());
        employee.setGender(request.getGender());
        employee.setPanNumber(request.getPanNumber());
        employee.setAadhaarNumber(request.getAadhaarNumber());
        employee.setPosition(request.getPosition());
        employee.setEmployeeId(request.getEmployeeId());
        mongoTemplate.save(employee, "employee");
        return new ApiResponse<>(AppConstants.SUCCESS,
                "Employee created successfully !!!",
                HttpStatus.CREATED.value(),
                employee
        );
    }

    @Override
    public List<Map<String, Object>> fetchEmployeeData(List<String> requestedFields) {
        if (requestedFields == null || requestedFields.isEmpty()) {
            throw new RuntimeException("No fields requested");
        }

        //Creates a MongoDB query including only the requested fields and fetches matching documents from the employee collection.
        //Converts each document to a map so the API can return only the requested fields dynamically.
        Query query = new Query();
        requestedFields.forEach(field -> query.fields().include(field));

        List<Document> docs = mongoTemplate.find(query, Document.class, "employee");
        return docs.stream()
                .map(doc -> (Map<String, Object>) doc)
                .toList();
    }

}
