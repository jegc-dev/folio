package com.dms.folio.repository;

import com.dms.folio.model.Area;
import com.dms.folio.model.Company;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository repository;

    @Test
    public void saveCompany() {


        Company company = Company.builder()
                .name("MCM Music Factory")
                .nit("707.345.345")
                .build();

        repository.save(company);

        Assertions.assertThat(company.getId()).isGreaterThan(0);
    }

    @Test
    public void saveCompanyWithAreas() {


        Area areaC = Area.builder()
                .code("C01")
                .name("Contabilidad")
                .build();

        Area areaF = Area.builder()
                .code("F01")
                .name("Finanzas")
                .build();

        Company company = Company.builder()
                .name("MCM Music Factory")
                .nit("808.345.345")
                .areaList(List.of(areaF, areaC))
                .build();

        repository.save(company);

        Assertions.assertThat(company.getId()).isGreaterThan(0);
    }

    @Test
    public void saveCompanyWithAreasCheckContainsAreas() {


        Area areaC02 = Area.builder()
                .code("C02")
                .name("Capacitacion")
                .build();

        Area areaC03 = Area.builder()
                .code("C03")
                .name("Cobranzas")
                .build();

        Company company = Company.builder()
                .name("MCM Music Factory")
                .nit("909.345.345")
                .areaList(List.of(areaC03, areaC02))
                .build();

        repository.save(company);

        Assertions.assertThat(company.getAreaList().size()).isEqualTo(2);
        Assertions.assertThat(areaC02.getId()).isGreaterThan(0);
        Assertions.assertThat(areaC03.getId()).isGreaterThan(0);

    }
}