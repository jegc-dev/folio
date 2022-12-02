package com.dms.folio.service.impl;

import com.dms.folio.exception.PointOfEntryNotFoundException;
import com.dms.folio.model.PointOfEntry;
import com.dms.folio.repository.PointOfEntryRepository;
import com.dms.folio.service.PointOfEntryService;
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
public class PointOfEntryServiceImpl implements PointOfEntryService {

    private final PointOfEntryRepository repository;

    @Override
    public PointOfEntry create(PointOfEntry pointOfEntry) {
        log.info("Creating a new PointOfEntry: {}", pointOfEntry.getDateOfEntry());
        return repository.save(pointOfEntry);
    }

    @Override
    public Collection<PointOfEntry> list(int limit) {
        log.info("Fetching all PointOfEntries");
        return repository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public PointOfEntry get(Long id) {
        log.info("Fetching a PointOfEntry: {}", id);
        return repository.findById(id).orElseThrow(() -> new PointOfEntryNotFoundException("PointOfEntry by id {" + id + "} was not found"));

    }

    @Override
    public PointOfEntry update(PointOfEntry pointOfEntry) {
        log.info("Updating a PointOfEntry: {}", pointOfEntry.getDateOfEntry());
        return repository.save(pointOfEntry);
    }
}
/*
* TODO:
*  1. How to generate input/output unique number.
*  2. How to generate barcode structure.
*  3. Refactor model and service
*
 */