package com.example.manager_chemical_test.controller;

import com.example.manager_chemical_test.dto.Apiresponse.ApiResponse;
import com.example.manager_chemical_test.dto.Authentication.AuthenticationRequest;
import com.example.manager_chemical_test.dto.Authentication.AuthenticationResponse;
import com.example.manager_chemical_test.dto.Introspect.IntrospectRequest;
import com.example.manager_chemical_test.dto.Introspect.IntrospectResponse;
import com.example.manager_chemical_test.dto.request.LogoutRequest;
import com.example.manager_chemical_test.service.Impl.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        var result = authenticationService.authenticate(request);
        return  ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }


    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest introspectRequest)
    throws ParseException, JOSEException {
        var result = authenticationService.introspect(introspectRequest);
        return  ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.<Void>builder().build();
    }

}
