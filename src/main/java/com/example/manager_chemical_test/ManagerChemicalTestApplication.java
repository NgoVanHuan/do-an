package com.example.manager_chemical_test;

//import com.example.manager_chemical_test.config.ModelMapper;
import org.mapstruct.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
        (exclude = {SecurityAutoConfiguration.class })
//@ComponentScan({"com.example.manager_chemical_test.mapper"
//        ,"com.example.manager_chemical_test"}
//)
public class ManagerChemicalTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerChemicalTestApplication.class, args);
    }

}
