package com.dms.folio.service;

import com.dms.folio.model.DocumentaryType;

import java.util.Collection;

public interface DocumentaryTypeService {

    DocumentaryType create(DocumentaryType documentaryType);
    Collection<DocumentaryType> list(int limit);
    DocumentaryType get(Long id);
    DocumentaryType update(DocumentaryType documentaryType);
}
