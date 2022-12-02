package com.dms.folio.service.impl;

import com.dms.folio.exception.AreaNotFoundException;
import com.dms.folio.model.Area;
import com.dms.folio.repository.AreaRepository;
import com.dms.folio.service.AreaService;
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
public class AreaServiceImpl implements AreaService {

    private final AreaRepository repository;

    @Override
    public Area create(Area area) {
        log.info("Creating a new Area: {}", area.getCode());
        return repository.save(area);
    }

    @Override
    public Collection<Area> list(int limit) {
        log.info("Fetching all Areas");
        return repository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Area get(Long id) {
        log.info("Fetching a Area: {}", id);
        return repository.findById(id).orElseThrow(() -> new AreaNotFoundException("Area by id {" + id + "} was not found"));

    }

    @Override
    public Area update(Area area) {
        log.info("Updating a Area: {}", area.getCode());
        return repository.save(area);
    }
}
