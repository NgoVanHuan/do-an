package com.example.manager_chemical_test.controller;


import com.example.manager_chemical_test.dto.Apiresponse.ApiResponse;
import com.example.manager_chemical_test.dto.ChemicalDTO;
import com.example.manager_chemical_test.dto.UserResponse;
import com.example.manager_chemical_test.dto.request.ChemicalRequest;
import com.example.manager_chemical_test.dto.request.UserUpdateRequest;
import com.example.manager_chemical_test.service.IChemicalService;
import com.example.manager_chemical_test.service.IUserService;
import com.example.manager_chemical_test.service.Impl.CategoriesService;
import com.example.manager_chemical_test.service.Impl.ChemicalService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chemical")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChemicalController {
//    @Autowired
//    IChemicalService chemicalsService;
//    @Autowired
//    CategoriesService categoriesService;
//
//
//    //    @GetMapping
////    public List<chemicalDTO> getAllPosts() {
////        return ichemicalsService.getAllchemicals_entity().stream().map(post -> ModelMapper.map(chemicals_entity, chemicalDTO.class))
////                .collect(Collectors.toList());
////    }
////    @GetMapping("/your")
////    public List<chemicalDTO> getAllPosts() {
////        return ichemicalsService.getAllchemicals_entity().stream()
////                .map(chemicalsEntity -> modelMapper.map(chemicalsEntity, chemicalDTO.class))
////                .collect(Collectors.toList());
////    }
//    @GetMapping("/all")
//    public List<ChemicalDTO> getAllChemicals() {
//        return chemicalsService.findAlll();
//    }
//    @PostMapping(value = "/create")
//    ApiResponse<ChemicalDTO> createChemical(@RequestBody @Valid ChemicalRequest model) {
//        ApiResponse<ChemicalDTO> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(chemicalsService.createChemical(model));
//        return apiResponse;
//    }
//    @GetMapping("/alls")
//    ApiResponse<List<ChemicalDTO>> getUsers() {
////         var authentication  =SecurityContextHolder.getContext().getAuthentication();
////         log.info("Username: {}", authentication.getName());
////         authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
//        return ApiResponse.<List<ChemicalDTO>>builder()
//                .result(chemicalsService.findAlll())
//                .build();
//    }
//    @DeleteMapping("/{Id}")
//    ApiResponse<String> deleteChemical(@PathVariable long Id) {
//        chemicalsService.delete(Id);
//        return ApiResponse.<String>builder().result("Chemical has been deleted").build();
//    }



    @Autowired
    private ChemicalService chemicalsService;

    @GetMapping
    public ApiResponse<List<ChemicalDTO>> getAllChemicals() {
        List<ChemicalDTO> chemicals = chemicalsService.getAllChemicals();
        return ApiResponse.<List<ChemicalDTO>>builder()
                .code(1000)
                .message("Success")
                .result(chemicals)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ChemicalDTO> getChemicalById(@PathVariable Long id) {
        ChemicalDTO chemical = chemicalsService.getChemicalById(id);
        if (chemical != null) {
            return ApiResponse.<ChemicalDTO>builder()
                    .code(1000)
                    .message("Success")
                    .result(chemical)
                    .build();
        } else {
            return ApiResponse.<ChemicalDTO>builder()
                    .code(404)
                    .message("Chemical not found")
                    .build();
        }
    }

    @PostMapping
    public ApiResponse<ChemicalDTO> createChemical(@RequestBody @Valid ChemicalDTO chemicalsDTO) {
        ChemicalDTO createdChemical = chemicalsService.createChemical(chemicalsDTO);
        return ApiResponse.<ChemicalDTO>builder()
                .code(1000)
                .message("Chemical created successfully")
                .result(createdChemical)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ChemicalDTO> updateChemical(@PathVariable Long id, @RequestBody @Valid ChemicalDTO chemicalsDTO) {
        ChemicalDTO updatedChemical = chemicalsService.updateChemical(id, chemicalsDTO);
        if (updatedChemical != null) {
            return ApiResponse.<ChemicalDTO>builder()
                    .code(1000)
                    .message("Chemical updated successfully")
                    .result(updatedChemical)
                    .build();
        } else {
            return ApiResponse.<ChemicalDTO>builder()
                    .code(404)
                    .message("Chemical not found")
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteChemical(@PathVariable Long id) {
        chemicalsService.deleteChemical(id);
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("Chemical deleted successfully")
                .build();
    }



}
