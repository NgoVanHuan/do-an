package com.example.manager_chemical_test.service.Impl;


import com.example.manager_chemical_test.dto.ChemicalDTO;
import com.example.manager_chemical_test.dto.request.ChemicalRequest;
import com.example.manager_chemical_test.entity.ChemicalsEntity;

import com.example.manager_chemical_test.mapper.ChemicalMapper;
import com.example.manager_chemical_test.repository.ChemicalRepository;
import com.example.manager_chemical_test.service.IChemicalService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ChemicalService implements IChemicalService {

         ChemicalRepository chemicalRepository;
         ChemicalMapper chemicalMapper;




        @Override
        public ChemicalDTO createChemical(ChemicalDTO request) {
        ChemicalsEntity chemicalsEntity = chemicalMapper.toEntity(request);
        ChemicalsEntity savedChemicalEntity = chemicalRepository.save(chemicalsEntity);
        ChemicalDTO savedChemicalDTO = chemicalMapper.toDto(savedChemicalEntity);
        return savedChemicalDTO;
    }



    @Override
    public List<ChemicalDTO> findAlll() {
        List<ChemicalsEntity> chemicalsEntities = chemicalRepository.findAll();
        return chemicalsEntities.stream()
                .map(chemicalMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long Id) {
        chemicalRepository.deleteById(Id);
    }


}

