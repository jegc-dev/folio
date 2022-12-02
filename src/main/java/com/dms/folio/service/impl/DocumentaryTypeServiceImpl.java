package com.dms.folio.service.impl;

import com.dms.folio.exception.DocumentaryTypeNotFoundException;
import com.dms.folio.model.DocumentaryType;
import com.dms.folio.repository.DocumentaryTypeRepository;
import com.dms.folio.service.DocumentaryTypeService;
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
public class DocumentaryTypeServiceImpl implements DocumentaryTypeService {

    private final DocumentaryTypeRepository repository;

    @Override
    public DocumentaryType create(DocumentaryType documentaryType) {
        log.info("Creating a new DocumentaryType: {}", documentaryType.getCode());
        return repository.save(documentaryType);
    }

    @Override
    public Collection<DocumentaryType> list(int limit) {
        log.info("Fetching all DocumentaryTypes");
        return repository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public DocumentaryType get(Long id) {
        log.info("Fetching a DocumentaryType: {}", id);
        return repository.findById(id).orElseThrow(() -> new DocumentaryTypeNotFoundException("DocumentaryType by id {" + id + "} was not found"));

    }

    @Override
    public DocumentaryType update(DocumentaryType documentaryType) {
        log.info("Updating a DocumentaryType: {}", documentaryType.getCode());
        return repository.save(documentaryType);
    }
}
