package com.dms.folio.repository;

import com.dms.folio.model.Series;
import com.dms.folio.model.SubSeries;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SeriesRepositoryTest {

    @Autowired
    SeriesRepository repository;

    @Test
    void saveSeries() {

        Series ser01 = Series.builder()
                .code("A01")
                .name("Actas")
                .build();

        repository.save(ser01);

        Assertions.assertThat(ser01.getId()).isGreaterThan(0);
    }

    @Test
    void saveSeriesWithSubSeries() {

        SubSeries subSer01 = SubSeries.builder()
                .code("AC01")
                .name("Actas de Comite")
                .build();

        Series ser01 = Series.builder()
                .code("A01")
                .name("Actas")
                .subSeriesList(List.of(subSer01))
                .build();

        repository.save(ser01);

        Assertions.assertThat(ser01.getId()).isGreaterThan(0);
        Assertions.assertThat(subSer01.getId()).isGreaterThan(0);
    }
}