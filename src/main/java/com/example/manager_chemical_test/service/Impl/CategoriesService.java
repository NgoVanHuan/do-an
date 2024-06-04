package com.example.manager_chemical_test.service.Impl;

import com.example.manager_chemical_test.dto.CategoriesDTO;
import com.example.manager_chemical_test.dto.request.CategoryRequest;
import com.example.manager_chemical_test.entity.CategoriesEntity;
import com.example.manager_chemical_test.mapper.CategoriesMapper;
import com.example.manager_chemical_test.repository.CategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoriesService {
    CategoriesRepository categoriesRepository;
    CategoriesMapper categoriesMapper;

    public CategoriesDTO create(CategoryRequest request) {
        CategoriesEntity categories = categoriesMapper.toCategory(request);
        categories = categoriesRepository.save(categories);
        return categoriesMapper.toDTO(categories);
    }

    public List<CategoriesDTO> getAll() {
        var categoriesEntities = categoriesRepository.findAll();
        return categoriesEntities.stream().map(categoriesMapper::toDTO).toList();
    }

    public void delete(Long category) {
        categoriesRepository.deleteById(category);
    }
}
