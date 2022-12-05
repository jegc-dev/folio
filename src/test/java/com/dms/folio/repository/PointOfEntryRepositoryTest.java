package com.dms.folio.repository;

import com.dms.folio.model.EntryType;
import com.dms.folio.model.PointOfEntry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class PointOfEntryRepositoryTest {


    @Autowired
    PointOfEntryRepository repository;

    @Test
    void addNewEntry() {

        PointOfEntry entry1 = PointOfEntry.builder()
                .entryType(EntryType.OUT)
                .entryCode(UUID.randomUUID().toString())
                .dateOfEntry(LocalDateTime.now())
                .documentId("Informe_de_Seguimiento.pdf")
                .subject("Informe de seguimiento avances de implementacion")
                .remarks("Reunion de avances en el proceso de implementacion")
                .build();

        repository.save(entry1);

        Assertions.assertThat(entry1.getId()).isGreaterThan(0);
    }
}