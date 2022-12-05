package com.dms.folio.repository;

import com.dms.folio.model.EntryType;
import com.dms.folio.model.PointOfEntry;
import com.dms.folio.model.SubSeries;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    @Test
    void saveSubSeriesWithFileEntries() {

        PointOfEntry entry1 = PointOfEntry.builder()
                .entryType(EntryType.IN)
                .entryCode(UUID.randomUUID().toString())
                .dateOfEntry(LocalDateTime.now())
                .documentId("Acta_de_Seguimiento.pdf")
                .subject("Actas de seguimiento avances de implementacion")
                .remarks("Reunion de avances en el proceso de implementacion")
                .build();

        SubSeries ss01 = SubSeries.builder()
                .code("ACS01")
                .name("Acta de Comite Sistemas")
                .entriesCollection(List.of(entry1))
                .build();

        repository.save(ss01);

        Assertions.assertThat(ss01.getId()).isGreaterThan(0);
        Assertions.assertThat(entry1.getId()).isGreaterThan(0);

    }

}