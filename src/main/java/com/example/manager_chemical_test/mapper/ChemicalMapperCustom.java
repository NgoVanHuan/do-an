package com.example.manager_chemical_test.mapper;

import com.example.manager_chemical_test.dto.ChemicalDTO;
import com.example.manager_chemical_test.dto.request.ChemicalRequest;
import com.example.manager_chemical_test.entity.ChemicalsEntity;
import com.example.manager_chemical_test.repository.CategoriesRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

//@Mapper(componentModel = "spring"
//        //,injectionStrategy = InjectionStrategy.CONSTRUCTOR
//)
@Component
public class ChemicalMapperCustom {
//    private final ChemicalMapper chemicalMapper;
//    private final CategoriesMapper categoriesMapper;
//    private final CategoriesRepository categoriesRepository;
//
//    public ChemicalMapperCustom(
//            ChemicalMapper chemicalMapper,
//            CategoriesRepository categoriesRepository,
//            CategoriesMapper categoriesMapper
//    ) {
//        this.chemicalMapper = chemicalMapper;
//        this.categoriesRepository = categoriesRepository;
//        this.categoriesMapper = categoriesMapper;
//    }
//
//    ChemicalsEntity toChemical(ChemicalRequest request){
//        var entity = chemicalMapper.toChemical(request);
//        return entity;
//    };
//
//    ChemicalDTO toChemicalDto(ChemicalsEntity entity){
//        var dto = chemicalMapper.toChemicalDTO(entity);
//        //find category byid
//        var category = categoriesRepository.findById(entity.getCategoryId()).orElse(null);
//        //set catetgory object to dto
//        dto.setCategories(categoriesMapper.toDTO(category));
//        return dto;
//    };
        //@Mapping(source = "casNumber", target = "casNo") // Chỉ định ánh xạ riêng cho casNumber
}



