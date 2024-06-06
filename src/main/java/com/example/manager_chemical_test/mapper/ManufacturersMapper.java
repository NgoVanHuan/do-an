package com.example.manager_chemical_test.mapper;

import com.example.manager_chemical_test.dto.CategoriesDTO;
import com.example.manager_chemical_test.dto.ChemicalDTO;
import com.example.manager_chemical_test.dto.ManufacturersDTO;
import com.example.manager_chemical_test.entity.CategoriesEntity;
import com.example.manager_chemical_test.entity.ChemicalsEntity;
import com.example.manager_chemical_test.entity.ManufacturersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

//import org.mapstruct.Mapper;
//@Mapper(componentModel = "spring"
//        //,injectionStrategy = InjectionStrategy.CONSTRUCTOR
//)
//public interface CategoriesMapper {
//    CategoriesEntity toCategory(CategoryRequest request);
//
//    CategoriesDTO toDTO(CategoriesEntity categories);
//        //@Mapping(source = "casNumber", target = "casNo") // Chỉ định ánh xạ riêng cho casNumber
//}


@Mapper(componentModel = "spring")
public interface ManufacturersMapper {
    ManufacturersMapper INSTANCE = Mappers.getMapper(ManufacturersMapper.class);

    @Mapping(target = "chemicals", qualifiedByName = "toChemicalsDTOList")
    ManufacturersDTO manufacturersToManufacturersDTO(ManufacturersEntity manufacturer);

    @Mapping(target = "chemicals", qualifiedByName = "toChemicalsList")
    ManufacturersEntity manufacturersDTOToManufacturers(ManufacturersDTO manufacturersDTO);

    @Named("toChemicalsDTOList")
    default List<ChemicalDTO> toChemicalsDTOList(List<ChemicalsEntity> chemicals) {
        if (chemicals == null) {
            return null;
        }
        return chemicals.stream()
                .map(ChemicalMapper.INSTANCE::chemicalsToChemicalsDTO)
                .collect(Collectors.toList());
    }

    @Named("toChemicalsList")
    default List<ChemicalsEntity> toChemicalsList(List<ChemicalDTO> chemicalsDTOs) {
        if (chemicalsDTOs == null) {
            return null;
        }
        return chemicalsDTOs.stream()
                .map(ChemicalMapper.INSTANCE::chemicalsDTOToChemicals)
                .collect(Collectors.toList());
    }
}