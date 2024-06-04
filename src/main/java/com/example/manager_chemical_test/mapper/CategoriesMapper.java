package com.example.manager_chemical_test.mapper;

import com.example.manager_chemical_test.dto.CategoriesDTO;
import com.example.manager_chemical_test.entity.CategoriesEntity;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring"
        //,injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CategoriesMapper extends EntityMapper<CategoriesEntity, CategoriesDTO> {
        //@Mapping(source = "casNumber", target = "casNo") // Chỉ định ánh xạ riêng cho casNumber
}
