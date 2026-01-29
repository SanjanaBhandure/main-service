package com.pertsol.mainservice.dto.request;

import lombok.Data;

import java.util.List;

/*
* Request DTO to pass selected fields for dynamic data fetching
 */
@Data
public class FieldRequest {
    public List<String> getFields() {
        return fields;
    }

    private List<String> fields;
}
