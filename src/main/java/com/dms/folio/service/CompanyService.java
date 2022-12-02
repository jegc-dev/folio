package com.dms.folio.service;

import com.dms.folio.model.Company;

import java.util.Collection;

public interface CompanyService {
    Company create(Company company);
    Collection<Company> list(int limit);
    Company get(Long id);
    Company update(Company company);
}
