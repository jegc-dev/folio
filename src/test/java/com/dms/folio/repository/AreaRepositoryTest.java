package com.dms.folio.repository;

import com.dms.folio.model.Area;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AreaRepositoryTest {

    @Autowired
    AreaRepository repository;

    @Test
    void saveArea() {

        Area areaG01 = Area.builder()
                .code("G01")
                .name("Gerencia Admnistrativa")
                .build();

        repository.save(areaG01);

        Assertions.assertThat(areaG01.getId()).isGreaterThan(0);

    }


    @Test
    void saveAreaWithSubAreas() {


        Area areaS01 = Area.builder()
                .code("S01")
                .name("Salud Ocupacional")
                .build();

        repository.save(areaS01);

        Assertions.assertThat(areaS01.getId()).isGreaterThan(0);


    }

}