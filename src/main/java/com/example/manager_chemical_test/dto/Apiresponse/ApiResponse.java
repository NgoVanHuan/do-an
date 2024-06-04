package com.example.manager_chemical_test.dto.Apiresponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T> {
    @Builder.Default
    private int code = 1000;
    private String message;
    private T result;
}
