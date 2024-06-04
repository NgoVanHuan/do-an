package com.example.manager_chemical_test.controller;

import com.example.manager_chemical_test.dto.Apiresponse.ApiResponse;
import com.example.manager_chemical_test.dto.CategoriesDTO;
import com.example.manager_chemical_test.dto.RoleResponse;
import com.example.manager_chemical_test.dto.request.CategoryRequest;
import com.example.manager_chemical_test.dto.request.RoleRequest;
import com.example.manager_chemical_test.service.Impl.CategoriesService;
import com.example.manager_chemical_test.service.Impl.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CategoryController {
    CategoriesService categoriesService;

    @PostMapping
    ApiResponse<CategoriesDTO> create(@RequestBody CategoryRequest request) {
        return ApiResponse.<CategoriesDTO>builder()
                .result(categoriesService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<CategoriesDTO>> getAll() {
        return ApiResponse.<List<CategoriesDTO>>builder()
                .result(categoriesService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> delete(@PathVariable Long ID) {
        categoriesService.delete(ID);
        return ApiResponse.<Void>builder().build();
    }
}
