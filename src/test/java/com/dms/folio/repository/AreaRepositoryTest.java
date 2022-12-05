package com.dms.folio.repository;

import com.dms.folio.model.Area;
import com.dms.folio.model.SubArea;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

        SubArea subAreaS01 = SubArea.builder()
                .code("SS01")
                .name("Seguridad Empresarial")
                .build();

        Area areaS01 = Area.builder()
                .code("S01")
                .name("Salud Ocupacional")
                .subAreaList(List.of(subAreaS01))
                .build();

        repository.save(areaS01);

        Assertions.assertThat(areaS01.getId()).isGreaterThan(0);
        Assertions.assertThat(subAreaS01.getId()).isGreaterThan(0);


    }

}