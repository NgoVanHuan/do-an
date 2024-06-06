package com.example.manager_chemical_test.service.Impl;

import com.example.manager_chemical_test.dto.ManufacturersDTO;
import com.example.manager_chemical_test.entity.ManufacturersEntity;
import com.example.manager_chemical_test.mapper.ManufacturersMapper;
import com.example.manager_chemical_test.repository.ManufacturersRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManufacturersService {
    @Autowired
    private ManufacturersRepository manufacturersRepository;

//    @Autowired
//    private ManufacturersMapper manufacturersMapper;
    ManufacturersMapper manufacturersMapper;

    public List<ManufacturersDTO> getAllManufacturers() {
        List<ManufacturersEntity> manufacturers = manufacturersRepository.findAll();
        return manufacturers.stream()
                .map(manufacturersMapper::manufacturersToManufacturersDTO)
                .collect(Collectors.toList());
    }

    public ManufacturersDTO getManufacturersById(Long id) {
        ManufacturersEntity manufacturer = manufacturersRepository.findById(id).orElse(null);
        return manufacturersMapper.manufacturersToManufacturersDTO(manufacturer);
    }

    public ManufacturersDTO createManufacturers(ManufacturersDTO manufacturersDTO) {
        ManufacturersEntity manufacturer = manufacturersMapper.manufacturersDTOToManufacturers(manufacturersDTO);
        manufacturer = manufacturersRepository.save(manufacturer);
        return manufacturersMapper.manufacturersToManufacturersDTO(manufacturer);
    }

    public ManufacturersDTO updateManufacturers(Long id, ManufacturersDTO manufacturersDTO) {
        if (manufacturersRepository.existsById(id)) {
            ManufacturersEntity manufacturer = manufacturersMapper.manufacturersDTOToManufacturers(manufacturersDTO);
            manufacturer.setId(id);
            manufacturer = manufacturersRepository.save(manufacturer);
            return manufacturersMapper.manufacturersToManufacturersDTO(manufacturer);
        }
        return null;
    }

    public void deleteManufacturers(Long id) {
        manufacturersRepository.deleteById(id);
    }
}
