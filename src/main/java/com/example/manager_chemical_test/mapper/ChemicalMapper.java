package com.example.manager_chemical_test.mapper;

import com.example.manager_chemical_test.dto.CategoriesDTO;
import com.example.manager_chemical_test.dto.ChemicalDTO;
import com.example.manager_chemical_test.dto.UserResponse;
import com.example.manager_chemical_test.dto.request.ChemicalRequest;
import com.example.manager_chemical_test.dto.request.UserCreationRequest;
import com.example.manager_chemical_test.dto.request.UserUpdateRequest;
import com.example.manager_chemical_test.entity.CategoriesEntity;
import com.example.manager_chemical_test.entity.ChemicalsEntity;
import com.example.manager_chemical_test.entity.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

//@Mapper(componentModel = "spring"
//        //,injectionStrategy = InjectionStrategy.CONSTRUCTOR
//)
//public interface ChemicalMapper {
//    ChemicalsEntity toChemical(ChemicalRequest request);
//    ChemicalDTO toChemicalDTO(ChemicalsEntity chemicalsEntity);
//    @Mapping(target = "categories", ignore = true)
//    void update(@MappingTarget ChemicalsEntity chemicals, ChemicalRequest request);
//        //@Mapping(source = "casNumber", target = "casNo") // Chỉ định ánh xạ riêng cho casNumber
//}


@Mapper(componentModel = "spring")
public interface ChemicalMapper {
    ChemicalMapper INSTANCE = Mappers.getMapper(ChemicalMapper.class);

    @Mapping(source = "categories.id", target = "categoryId")
    @Mapping(source = "manufacturers.id", target = "manufacturerId")
    ChemicalDTO chemicalsToChemicalsDTO(ChemicalsEntity chemicals);

    @Mapping(source = "categoryId", target = "categories.id")
    @Mapping(source = "manufacturerId", target = "manufacturers.id")
    ChemicalsEntity chemicalsDTOToChemicals(ChemicalDTO chemicalsDTO);
}



