package com.dms.folio.repository;

import com.dms.folio.model.SubSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubSeriesRepository extends JpaRepository<SubSeries, Long> {
}
