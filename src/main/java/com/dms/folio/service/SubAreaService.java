package com.dms.folio.service;

import com.dms.folio.model.Series;
import com.dms.folio.model.SubArea;

import java.util.Collection;

public interface SubAreaService {

    SubArea create(SubArea Subarea);

    Collection<SubArea> list(int limit);

    SubArea get(Long id);

    SubArea get(String code);

    SubArea update(SubArea Subarea);

    SubArea addSeries(String subAreaCode, Series series);
}
