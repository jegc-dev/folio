package com.dms.folio.repository;

import com.dms.folio.model.Area;
import com.dms.folio.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository repository;

    @Test
    public void saveCompany(){


        Area areaC = new Area();
        areaC.setName("Contabilidad");
        areaC.setCode("C01");

        Area areaF = new Area();
        areaF.setName("Finanzas");
        areaF.setCode("F01");

        Company company = Company.builder()
                        .name("MCM Music Factory")
                                .nit("808.345.345")
                                        .areaList(List.of(areaF,areaC))
                                                .build();


        repository.save(company);
    }

}