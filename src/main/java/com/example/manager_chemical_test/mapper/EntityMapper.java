package com.example.manager_chemical_test.mapper;

import org.springframework.stereotype.Component;


public interface EntityMapper<E, D> {
    E toEntity(D t);
    D toDto(E e);
}