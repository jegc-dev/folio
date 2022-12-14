package com.dms.folio.repository;

import com.dms.folio.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {

    Optional<Area> findAreaByCode(String code);


}
