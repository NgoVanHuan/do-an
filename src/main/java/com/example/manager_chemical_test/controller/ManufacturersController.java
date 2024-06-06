package com.example.manager_chemical_test.controller;

import com.example.manager_chemical_test.dto.Apiresponse.ApiResponse;

import com.example.manager_chemical_test.dto.ManufacturersDTO;
import com.example.manager_chemical_test.service.Impl.ManufacturersService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ManufacturersController {
    @Autowired
    private ManufacturersService manufacturersService;

    @GetMapping
    public ApiResponse<List<ManufacturersDTO>> getAllManufacturers() {
        List<ManufacturersDTO> manufacturers = manufacturersService.getAllManufacturers();
        return ApiResponse.<List<ManufacturersDTO>>builder()
                .code(1000)
                .message("Success")
                .result(manufacturers)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ManufacturersDTO> getManufacturersById(@PathVariable Long id) {
        ManufacturersDTO manufacturer = manufacturersService.getManufacturersById(id);
        if (manufacturer != null) {
            return ApiResponse.<ManufacturersDTO>builder()
                    .code(1000)
                    .message("Success")
                    .result(manufacturer)
                    .build();
        } else {
            return ApiResponse.<ManufacturersDTO>builder()
                    .code(404)
                    .message("Manufacturer not found")
                    .build();
        }
    }

    @PostMapping
    public ApiResponse<ManufacturersDTO> createManufacturers(@RequestBody @Valid ManufacturersDTO manufacturersDTO) {
        ManufacturersDTO createdManufacturer = manufacturersService.createManufacturers(manufacturersDTO);
        return ApiResponse.<ManufacturersDTO>builder()
                .code(1000)
                .message("Manufacturer created successfully")
                .result(createdManufacturer)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ManufacturersDTO> updateManufacturers(@PathVariable Long id, @RequestBody @Valid ManufacturersDTO manufacturersDTO) {
        ManufacturersDTO updatedManufacturer = manufacturersService.updateManufacturers(id, manufacturersDTO);
        if (updatedManufacturer != null) {
            return ApiResponse.<ManufacturersDTO>builder()
                    .code(1000)
                    .message("Manufacturer updated successfully")
                    .result(updatedManufacturer)
                    .build();
        } else {
            return ApiResponse.<ManufacturersDTO>builder()
                    .code(404)
                    .message("Manufacturer not found")
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteManufacturers(@PathVariable Long id) {
        manufacturersService.deleteManufacturers(id);
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("Manufacturer deleted successfully")
                .build();
    }
}
