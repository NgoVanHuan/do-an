package com.example.manager_chemical_test.controller;

import com.example.manager_chemical_test.dto.Apiresponse.ApiResponse;
import com.example.manager_chemical_test.dto.CategoriesDTO;
import com.example.manager_chemical_test.dto.RoleResponse;
import com.example.manager_chemical_test.dto.request.CategoryRequest;
import com.example.manager_chemical_test.dto.request.RoleRequest;
import com.example.manager_chemical_test.service.Impl.CategoriesService;
import com.example.manager_chemical_test.service.Impl.RoleService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CategoryController {
//    CategoriesService categoriesService;
//
//    @PostMapping
//    ApiResponse<CategoriesDTO> create(@RequestBody CategoryRequest request) {
//        return ApiResponse.<CategoriesDTO>builder()
//                .result(categoriesService.create(request))
//                .build();
//    }
//
//    @GetMapping
//    ApiResponse<List<CategoriesDTO>> getAll() {
//        return ApiResponse.<List<CategoriesDTO>>builder()
//                .result(categoriesService.getAll())
//                .build();
//    }
//
//    @DeleteMapping("/{ID}")
//    ApiResponse<Void> delete(@PathVariable Long ID) {
//        categoriesService.delete(ID);
//        return ApiResponse.<Void>builder().build();
//    }


    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public ApiResponse<List<CategoriesDTO>> getAllCategories() {
        List<CategoriesDTO> categories = categoriesService.getAllCategories();
        return ApiResponse.<List<CategoriesDTO>>builder()
                .code(1000)
                .message("Success")
                .result(categories)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<CategoriesDTO> getCategoriesById(@PathVariable Long id) {
        CategoriesDTO category = categoriesService.getCategoriesById(id);
        if (category != null) {
            return ApiResponse.<CategoriesDTO>builder()
                    .code(1000)
                    .message("Success")
                    .result(category)
                    .build();
        } else {
            return ApiResponse.<CategoriesDTO>builder()
                    .code(404)
                    .message("Category not found")
                    .build();
        }
    }

    @PostMapping
    public ApiResponse<CategoriesDTO> createCategories(@RequestBody @Valid CategoriesDTO categoriesDTO) {
        CategoriesDTO createdCategory = categoriesService.createCategories(categoriesDTO);
        return ApiResponse.<CategoriesDTO>builder()
                .code(1000)
                .message("Category created successfully")
                .result(createdCategory)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoriesDTO> updateCategories(@PathVariable Long id, @RequestBody @Valid CategoriesDTO categoriesDTO) {
        CategoriesDTO updatedCategory = categoriesService.updateCategories(id, categoriesDTO);
        if (updatedCategory != null) {
            return ApiResponse.<CategoriesDTO>builder()
                    .code(1000)
                    .message("Category updated successfully")
                    .result(updatedCategory)
                    .build();
        } else {
            return ApiResponse.<CategoriesDTO>builder()
                    .code(404)
                    .message("Category not found")
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCategories(@PathVariable Long id) {
        categoriesService.deleteCategories(id);
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("Category deleted successfully")
                .build();
    }
}
