package com.dms.folio.repository;

import com.dms.folio.model.PointOfEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfEntryRepository extends JpaRepository<PointOfEntry, Long> {
}
