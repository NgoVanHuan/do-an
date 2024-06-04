package com.example.manager_chemical_test.service.Impl;

import com.example.manager_chemical_test.dto.CategoriesDTO;
import com.example.manager_chemical_test.entity.CategoriesEntity;
import com.example.manager_chemical_test.mapper.CategoriesMapper;
import com.example.manager_chemical_test.mapper.CategoriesMapperImpl;
import com.example.manager_chemical_test.repository.CategoriesRepository;
import com.example.manager_chemical_test.service.ICategoriesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriesService implements ICategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoriesMapperImpl categoriesMapper;
//    @Override
//    public CategoriesDTO getById(Long id) {
//        CategoriesEntity categoriesEntity = categoriesRepository.findById(id).get();
//        return categoriesMapper.mapToCategoriesDTO(categoriesEntity);
//    }
    @Override
    public CategoriesDTO getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        Optional<CategoriesEntity> optionalCategoriesEntity = categoriesRepository.findById(id);
        if (optionalCategoriesEntity.isPresent()) {
            return categoriesMapper.toDto(optionalCategoriesEntity.get());
        } else {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
    }
    @Override
    public CategoriesDTO save(CategoriesDTO categoriesDTO) {
        var categoriesEntity = categoriesMapper.toEntity(categoriesDTO);
                if(categoriesRepository.existsByCategoryName(categoriesDTO.getCategoryName())){
            throw  new RuntimeException("category existed");
        }
        if (categoriesEntity.getId() == null) {
            return categoriesMapper.toDto(categoriesRepository.save(categoriesEntity));
        }
        var categoryOld = categoriesRepository.findById(categoriesEntity.getId()).orElse(null);
        if (categoryOld != null) {
            if (Objects.equals(categoryOld.getCategoryName(),categoriesEntity.getCategoryName())) {
                throw  new RuntimeException("category existed");
            }
        }
        return categoriesMapper.toDto(categoriesRepository.save(categoriesEntity));
//        if(categoriesRepository.existsByCategoryName(categoriesDTO.getCategory_name())){
//            throw  new RuntimeException("category existed");
//        }
//        if (categoriesDTO.getId() != null) {
//            Optional<CategoriesEntity> optionalTicketEntity = categoriesRepository.findById(categoriesDTO.getId());
//            CategoriesEntity oldCategoryEntity = optionalTicketEntity.orElse(null);
//
//            categoriesEntity = categoriesMapper.toEntity(categoriesDTO);
//        } else {
//            categoriesEntity = categoriesMapper.mapToCategoriesEntity(categoriesDTO);
//        }
//        CategoriesEntity savedEntity = categoriesRepository.save(categoriesEntity);
//        return categoriesMapper.mapToCategoriesDTO(savedEntity);

    }
    @Override
    public void delete(long[] ids) {
        for(long id: ids) {
            categoriesRepository.deleteById(id);
        }
    }
}
