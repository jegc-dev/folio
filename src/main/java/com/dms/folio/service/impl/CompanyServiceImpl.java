package com.dms.folio.service.impl;

import com.dms.folio.exception.CompanyNotFoundException;
import com.dms.folio.model.Company;
import com.dms.folio.repository.CompanyRepository;
import com.dms.folio.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public Company create(Company company) {
        log.info("Creating a new Company: {}", company.getNit());
        return repository.save(company);
    }

    @Override
    public Collection<Company> list(int limit) {
        log.info("Fetching all Companies");
        return repository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Company get(Long id) {
        log.info("Fetching a Company: {}", id);
        return repository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company by id {" + id + "} was not found"));
    }

    @Override
    public Company update(Company company) {
        log.info("Updating a new Company: {}", company.getNit());
        return repository.save(company);
    }
}
