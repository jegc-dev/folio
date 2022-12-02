package com.dms.folio.service.impl;

import com.dms.folio.exception.SubSeriesNotFoundException;
import com.dms.folio.model.SubSeries;
import com.dms.folio.repository.SubSeriesRepository;
import com.dms.folio.service.SubSeriesService;
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
public class SubSeriesServiceImpl implements SubSeriesService {

    private final SubSeriesRepository repository;

    @Override
    public SubSeries create(SubSeries subSeries) {
        log.info("Creating a new SubSeries: {}", subSeries.getCode());
        return repository.save(subSeries);
    }

    @Override
    public Collection<SubSeries> list(int limit) {
        log.info("Fetching all SubSeries");
        return repository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public SubSeries get(Long id) {
        log.info("Fetching a SubSeries: {}", id);
        return repository.findById(id).orElseThrow(() -> new SubSeriesNotFoundException("SubSeries by id {" + id + "} was not found"));

    }

    @Override
    public SubSeries update(SubSeries subSeries) {
        log.info("Updating a SubSeries: {}", subSeries.getCode());
        return repository.save(subSeries);
    }
}
