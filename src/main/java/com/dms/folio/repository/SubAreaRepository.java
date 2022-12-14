package com.dms.folio.repository;

import com.dms.folio.model.SubArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubAreaRepository extends JpaRepository<SubArea, Long> {

    Optional<SubArea> findSubAreaByCode(String code);
}
