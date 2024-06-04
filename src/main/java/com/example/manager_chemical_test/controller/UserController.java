package com.example.manager_chemical_test.controller;


import com.example.manager_chemical_test.dto.Apiresponse.ApiResponse;
import com.example.manager_chemical_test.dto.UserResponse;
import com.example.manager_chemical_test.dto.request.UserCreationRequest;
import com.example.manager_chemical_test.dto.request.UserUpdateRequest;
import com.example.manager_chemical_test.service.IUserService;
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
@RequestMapping(value = "/home")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {


    @Autowired
    IUserService iUserService;

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
    @GetMapping("/your")
    public String getAllPosts() {
        return "Onus là món quà của thượng đế , hãy tải và trải nghiệm ngay";
    }

    //    @GetMapping("/create")
//    public ChemicalDTO createChemical(){
//        ChemicalDTO newChemicalDTO = new ChemicalDTO();
//        newChemicalDTO.setChemiocalName("New Chemical Name");
//        return newChemicalDTO;
//    }
//    @GetMapping("/all")
//    public List<ChemicalDTO> getAllChemicals() {
//        return ichemicalsService.findAlll();
//    }

//    @GetMapping("/category/{id}")
//    public CategoriesDTO getByIdCategory(@PathVariable Long id) {
//        return iCategoriesService.getById(id);
//    }
//
//    @PostMapping(value = "/category/create")
//    ApiResponse<CategoriesDTO> createCategory(@RequestBody @Valid CategoriesDTO model) {
//        ApiResponse<CategoriesDTO> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(iCategoriesService.save(model));
//        return apiResponse;
//    }
//
//    @PutMapping(value = "/category/create/{id}")
//    public CategoriesDTO updateCategory(@RequestBody CategoriesDTO model, @PathVariable("id") long id) {
//        model.setId(id);
//        return iCategoriesService.save(model);
//    }
//
//    @DeleteMapping(value = "/category/delete")
//    public ResponseEntity<String> deleteCategory(@RequestBody long[] ids) {
//        iCategoriesService.delete(ids);
//        String message = "Deleted successfully";
//        return ResponseEntity.ok().body(message);
//    }


    @PostMapping(value = "/user")
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest model) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(iUserService.createUser(model));
        return apiResponse;
    }

    //    @PutMapping(value = "/user/create/{id}")
//    public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") long id) {
//        model.setId(id);
//        return iUserService.save(model);
//    }
    @GetMapping("/user/{id}")
    ApiResponse<UserResponse> getById(@PathVariable Long id) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(iUserService.getById(id));
        return apiResponse;
    }

    @GetMapping("/users")
    ApiResponse<List<UserResponse>> getUsers() {
         var authentication  =SecurityContextHolder.getContext().getAuthentication();
         log.info("Username: {}", authentication.getName());
         authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return ApiResponse.<List<UserResponse>>builder()
                .result(iUserService.getByAll())
                .build();
    }
    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable long userId) {
        iUserService.deleteUser(userId);
        return ApiResponse.<String>builder().result("User has been deleted").build();
    }


//    @PutMapping(value = "/user/create/{id}")
//    public UserResponse updateUser(@RequestBody UserResponse model, @PathVariable("id") long id) {
//        model.setId(id);
//        return iUserService.save(model);
//    }
    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(iUserService.updateUser(userId, request))
                .build();
    }

    @GetMapping("/myinfo")
    ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .result(iUserService.getMyInfo())
                .build();
    }
}
