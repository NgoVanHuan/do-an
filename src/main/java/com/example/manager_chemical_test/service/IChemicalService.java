package com.example.manager_chemical_test.service;

import com.example.manager_chemical_test.dto.ChemicalDTO;
import com.example.manager_chemical_test.dto.request.ChemicalRequest;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IChemicalService  {
        @PreAuthorize("hasRole('ADMIN')")
        ChemicalDTO createChemical (ChemicalDTO chemicalDTO);
        @PreAuthorize("hasRole('ADMIN')")
        List<ChemicalDTO> findAlll();
        @PreAuthorize("hasRole('ADMIN')")
        void delete(Long Id);



}
