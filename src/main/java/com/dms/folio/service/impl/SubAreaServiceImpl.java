package com.dms.folio.service.impl;

import com.dms.folio.exception.SubAreaNotFoundException;
import com.dms.folio.model.Series;
import com.dms.folio.model.SubArea;
import com.dms.folio.repository.SubAreaRepository;
import com.dms.folio.service.SubAreaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class SubAreaServiceImpl implements SubAreaService {

    private final SubAreaRepository repository;

    @Override
    public SubArea create(SubArea Subarea) {
        log.info("Creating a new SubArea: {}", Subarea.getCode());
        return repository.save(Subarea);
    }

    @Override
    public Collection<SubArea> list(int limit) {
        log.info("Fetching all SubAreas");
        return repository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public SubArea get(Long id) {
        log.info("Fetching a SubArea: {}", id);
        return repository.findById(id).orElseThrow(() -> new SubAreaNotFoundException("SubArea by id {" + id + "} was not found"));

    }

    @Override
    public SubArea get(String code) {
        return repository.findSubAreaByCode(code).orElseThrow(() -> new SubAreaNotFoundException("SubArea by code {" + code + "} was not found"));
    }

    @Override
    public SubArea update(SubArea Subarea) {
        log.info("Updating a SubArea: {}", Subarea.getCode());
        return repository.save(Subarea);
    }


    @Override
    public SubArea addSeries(String subAreaCode, Series series) {

        SubArea subArea = this.get(subAreaCode);
        List<Series> seriesList = subArea.getSeriesList();

        seriesList.add(series);
        subArea.setSeriesList(seriesList);

        return repository.save(subArea);
    }
}
