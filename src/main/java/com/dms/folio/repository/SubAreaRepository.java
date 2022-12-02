package com.dms.folio.repository;

import com.dms.folio.model.SubArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubAreaRepository extends JpaRepository<SubArea, Long> {
}
