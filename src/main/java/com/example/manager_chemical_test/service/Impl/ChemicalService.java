package com.example.manager_chemical_test.service.Impl;


import com.example.manager_chemical_test.dto.ChemicalDTO;
import com.example.manager_chemical_test.dto.request.ChemicalRequest;
import com.example.manager_chemical_test.entity.ChemicalsEntity;
import com.example.manager_chemical_test.mapper.ChemicalMapper;

import com.example.manager_chemical_test.mapper.ChemicalMapperCustom;
import com.example.manager_chemical_test.repository.ChemicalRepository;
import com.example.manager_chemical_test.service.IChemicalService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ChemicalService  {
//    @Autowired
//    private ChemicalRepository chemicalRepository;
//    ChemicalMapper chemicalMapper;
//    ChemicalMapperCustom chemicalMapperCustom;
//
//    @Override
//    public ChemicalDTO createChemical(ChemicalRequest request) {
//        ChemicalsEntity chemicalsEntity = chemicalMapper.toChemical(request);
//        ChemicalsEntity savedChemicalEntity = chemicalRepository.save(chemicalsEntity);
//        ChemicalDTO savedChemicalDTO = chemicalMapper.toChemicalDTO(savedChemicalEntity);
//        return savedChemicalDTO;
//    }
//
//    @Override
//    public List<ChemicalDTO> findAlll() {
//        List<ChemicalsEntity> chemicalsEntities = chemicalRepository.findAll();
//        return chemicalsEntities.stream()
//                .map(chemicalMapper::toChemicalDTO)
//                .collect(Collectors.toList());
//    }
//    @Override
//    public void delete(Long Id) {
//        chemicalRepository.deleteById(Id);
//    }

    @Autowired
    private ChemicalRepository chemicalsRepository;

    @Autowired
    private ChemicalMapper chemicalsMapper;

    public List<ChemicalDTO> getAllChemicals() {
        List<ChemicalsEntity> chemicals = chemicalsRepository.findAll();
        return chemicals.stream()
                .map(chemicalsMapper::chemicalsToChemicalsDTO)
                .collect(Collectors.toList());
    }

    public ChemicalDTO getChemicalById(Long id) {
        ChemicalsEntity chemical = chemicalsRepository.findById(id).orElse(null);
        return chemicalsMapper.chemicalsToChemicalsDTO(chemical);
    }

    public ChemicalDTO createChemical(ChemicalDTO chemicalsDTO) {
        ChemicalsEntity chemical = chemicalsMapper.chemicalsDTOToChemicals(chemicalsDTO);
        chemical = chemicalsRepository.save(chemical);
        return chemicalsMapper.chemicalsToChemicalsDTO(chemical);
    }

    public ChemicalDTO updateChemical(Long id, ChemicalDTO chemicalsDTO) {
        if (chemicalsRepository.existsById(id)) {
            ChemicalsEntity chemical = chemicalsMapper.chemicalsDTOToChemicals(chemicalsDTO);
            chemical.setId(id);
            chemical = chemicalsRepository.save(chemical);
            return chemicalsMapper.chemicalsToChemicalsDTO(chemical);
        }
        return null;
    }

    public void deleteChemical(Long id) {
        chemicalsRepository.deleteById(id);
    }

}

