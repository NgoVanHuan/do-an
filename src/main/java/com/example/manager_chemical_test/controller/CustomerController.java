//package com.example.manager_chemical_test.controller;
//
//
//import com.example.manager_chemical_test.dto.Apiresponse.ApiResponse;
//import com.example.manager_chemical_test.dto.CustomerResponse;
//import com.example.manager_chemical_test.dto.PermissionResponse;
//import com.example.manager_chemical_test.dto.UserResponse;
//import com.example.manager_chemical_test.dto.request.CustomerRequest;
//import com.example.manager_chemical_test.dto.request.PermissionRequest;
//import com.example.manager_chemical_test.dto.request.UserUpdateRequest;
//import com.example.manager_chemical_test.service.Impl.CustomerService;
//import com.example.manager_chemical_test.service.Impl.PermissionService;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/customer")
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@Slf4j
//public class CustomerController {
//    CustomerService customerService;
//
//    @PostMapping
//    ApiResponse<CustomerResponse> create(@RequestBody CustomerRequest request) {
//        return ApiResponse.<CustomerResponse>builder()
//                .result(customerService.create(request))
//                .build();
//    }
//
//    @GetMapping
//    ApiResponse<List<CustomerResponse>> getAll() {
//        return ApiResponse.<List<CustomerResponse>>builder()
//                .result(customerService.getAll())
//                .build();
//    }
//
//    @DeleteMapping("/{customerID}")
//    ApiResponse<Void> delete(@PathVariable Long customerID) {
//        customerService.delete(customerID);
//        return ApiResponse.<Void>builder().build();
//    }
//
//    @PutMapping("/{Id}")
//    ApiResponse<CustomerResponse> updateUser(@PathVariable Long Id, @RequestBody CustomerRequest request) {
//        return ApiResponse.<CustomerResponse>builder()
//                .result(customerService.updateUser(Id, request))
//                .build();
//    }
//}
