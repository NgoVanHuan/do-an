package com.example.manager_chemical_test.controller;


import com.example.manager_chemical_test.dto.Apiresponse.ApiResponse;
import com.example.manager_chemical_test.dto.ChemicalDTO;
import com.example.manager_chemical_test.dto.UserResponse;
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
    @Autowired
    IChemicalService chemicalsService;
    @Autowired
    CategoriesService categoriesService;


    //    @GetMapping
//    public List<chemicalDTO> getAllPosts() {
//        return ichemicalsService.getAllchemicals_entity().stream().map(post -> ModelMapper.map(chemicals_entity, chemicalDTO.class))
//                .collect(Collectors.toList());
//    }
//    @GetMapping("/your")
//    public List<chemicalDTO> getAllPosts() {
//        return ichemicalsService.getAllchemicals_entity().stream()
//                .map(chemicalsEntity -> modelMapper.map(chemicalsEntity, chemicalDTO.class))
//                .collect(Collectors.toList());
//    }
    @GetMapping("/all")
    public List<ChemicalDTO> getAllChemicals() {
        return chemicalsService.findAlll();
    }


    @PostMapping(value = "/create")
    ApiResponse<ChemicalDTO> createChemical(@RequestBody @Valid ChemicalDTO model) {
        ApiResponse<ChemicalDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(chemicalsService.createChemical(model));
        return apiResponse;
    }

    @GetMapping("/alls")
    ApiResponse<List<ChemicalDTO>> getUsers() {
//         var authentication  =SecurityContextHolder.getContext().getAuthentication();
//         log.info("Username: {}", authentication.getName());
//         authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return ApiResponse.<List<ChemicalDTO>>builder()
                .result(chemicalsService.findAlll())
                .build();
    }
    @DeleteMapping("/{Id}")
    ApiResponse<String> deleteChemical(@PathVariable long Id) {
        chemicalsService.delete(Id);
        return ApiResponse.<String>builder().result("Chemical has been deleted").build();
    }


}
