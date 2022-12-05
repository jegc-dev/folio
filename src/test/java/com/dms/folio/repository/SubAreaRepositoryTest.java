package com.dms.folio.repository;

import com.dms.folio.model.Series;
import com.dms.folio.model.SubArea;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SubAreaRepositoryTest {

    @Autowired
    SubAreaRepository repository;

    @Test
    void saveSubArea() {

        SubArea subAreaS01 = SubArea.builder()
                .code("IS01")
                .name("Seguridad Informatica")
                .build();

        repository.save(subAreaS01);

        Assertions.assertThat(subAreaS01.getId()).isGreaterThan(0);


    }

    @Test
    void saveSubAreaWithSeries() {

        Series series01 = Series.builder()
                .code("ISA01")
                .name("Actas de Comite de S.I.")
                .build();

        SubArea subAreaS01 = SubArea.builder()
                .code("IS01")
                .name("Seguridad Informatica")
                .seriesList(List.of(series01))
                .build();

        repository.save(subAreaS01);

        Assertions.assertThat(subAreaS01.getId()).isGreaterThan(0);
        Assertions.assertThat(series01.getId()).isGreaterThan(0);

    }

}