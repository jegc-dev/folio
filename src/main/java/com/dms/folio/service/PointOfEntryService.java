package com.dms.folio.service;

import com.dms.folio.model.PointOfEntry;

import java.util.Collection;

public interface PointOfEntryService {

    PointOfEntry create(PointOfEntry pointOfEntry);
    Collection<PointOfEntry> list(int limit);
    PointOfEntry get(Long id);
    PointOfEntry update(PointOfEntry pointOfEntry);
}
