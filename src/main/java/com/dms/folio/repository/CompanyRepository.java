package com.dms.folio.repository;

import com.dms.folio.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByNit(String nit);
}
