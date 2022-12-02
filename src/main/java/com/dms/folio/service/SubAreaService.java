package com.dms.folio.service;

import com.dms.folio.model.SubArea;

import java.util.Collection;

public interface SubAreaService {

    SubArea create(SubArea Subarea);
    Collection<SubArea> list(int limit);
    SubArea get(Long id);
    SubArea update(SubArea Subarea);
}
