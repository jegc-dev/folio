package com.dms.folio.repository;

import com.dms.folio.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {

    //Optional<Area> findByCode(String code);


}
