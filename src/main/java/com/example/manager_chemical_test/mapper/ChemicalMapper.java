package com.example.manager_chemical_test.mapper;

import com.example.manager_chemical_test.dto.ChemicalDTO;
import com.example.manager_chemical_test.entity.ChemicalsEntity;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring"
        //,injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ChemicalMapper extends EntityMapper<ChemicalsEntity, ChemicalDTO> {
        //@Mapping(source = "casNumber", target = "casNo") // Chỉ định ánh xạ riêng cho casNumber
}



