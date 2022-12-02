package com.dms.folio.service.impl;

import com.dms.folio.exception.SeriesNotFoundException;
import com.dms.folio.model.Series;
import com.dms.folio.repository.SeriesRepository;
import com.dms.folio.service.SeriesService;
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
public class SeriesServiceImpl implements SeriesService {

    private final SeriesRepository repository;

    @Override
    public Series create(Series Series) {
        log.info("Creating a new Series: {}", Series.getCode());
        return repository.save(Series);
    }

    @Override
    public Collection<Series> list(int limit) {
        log.info("Fetching all Series");
        return repository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Series get(Long id) {
        log.info("Fetching a Series: {}", id);
        return repository.findById(id).orElseThrow(() -> new SeriesNotFoundException("Series by id {" + id + "} was not found"));

    }

    @Override
    public Series update(Series Series) {
        log.info("Updating a Series: {}", Series.getCode());
        return repository.save(Series);
    }
}
