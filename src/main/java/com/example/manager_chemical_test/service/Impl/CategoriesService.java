package com.example.manager_chemical_test.service.Impl;

import com.example.manager_chemical_test.dto.CategoriesDTO;
import com.example.manager_chemical_test.dto.request.CategoryRequest;
import com.example.manager_chemical_test.entity.CategoriesEntity;
import com.example.manager_chemical_test.mapper.CategoriesMapper;
import com.example.manager_chemical_test.repository.CategoriesRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@ToString
public class CategoriesService {
//    CategoriesRepository categoriesRepository;
//    CategoriesMapper categoriesMapper;
//
//    public CategoriesDTO create(CategoryRequest request) {
//        CategoriesEntity categories = categoriesMapper.toCategory(request);
//        System.out.println(request.toString()+ " AK1 ");
//        System.out.println(categories.toString()+ " AK2 ");
//        categories = categoriesRepository.save(categories);
//        return categoriesMapper.toDTO(categories);
//    }
//
//    public List<CategoriesDTO> getAll() {
//        var categoriesEntities = categoriesRepository.findAll();
//        return categoriesEntities.stream().map(categoriesMapper::toDTO).toList();
//    }
//
//    public void delete(Long category) {
//        categoriesRepository.deleteById(category);
//    }

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CategoriesMapper categoriesMapper;

    public List<CategoriesDTO> getAllCategories() {
        List<CategoriesEntity> categories = categoriesRepository.findAll();
        return categories.stream()
                .map(categoriesMapper::categoriesToCategoriesDTO)
                .collect(Collectors.toList());
    }

    public CategoriesDTO getCategoriesById(Long id) {
        CategoriesEntity category = categoriesRepository.findById(id).orElse(null);
        return categoriesMapper.categoriesToCategoriesDTO(category);
    }

    public CategoriesDTO createCategories(CategoriesDTO categoriesDTO) {
        CategoriesEntity category = categoriesMapper.categoriesDTOToCategories(categoriesDTO);
        category = categoriesRepository.save(category);
        return categoriesMapper.categoriesToCategoriesDTO(category);
    }

    public CategoriesDTO updateCategories(Long id, CategoriesDTO categoriesDTO) {
        if (categoriesRepository.existsById(id)) {
            CategoriesEntity category = categoriesMapper.categoriesDTOToCategories(categoriesDTO);
            category.setId(id);
            category = categoriesRepository.save(category);
            return categoriesMapper.categoriesToCategoriesDTO(category);
        }
        return null;
    }

    public void deleteCategories(Long id) {
        categoriesRepository.deleteById(id);
    }
}
