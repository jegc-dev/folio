package com.dms.folio.service;

import com.dms.folio.model.Area;

import java.util.Collection;

public interface AreaService {

    Area create(Area area);

    Collection<Area> list(int limit);

    Area get(Long id);

    Area get(String code);

    Area update(Area area);

}
