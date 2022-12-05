package com.dms.folio.repository;

import com.dms.folio.model.SubSeries;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubSeriesRepositoryTest {

    @Autowired
    SubSeriesRepository repository;

    @Test
    void saveSubSeries() {

        SubSeries ss01 = SubSeries.builder()
                .code("ACD01")
                .name("Acta de comite Disciplinario")
                .build();

        repository.save(ss01);

        Assertions.assertThat(ss01.getId()).isGreaterThan(0);

    }

}