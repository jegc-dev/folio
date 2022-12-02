package com.dms.folio.service;


import com.dms.folio.model.SubSeries;

import java.util.Collection;

public interface SubSeriesService {

    SubSeries create(SubSeries subSeries);
    Collection<SubSeries> list(int limit);
    SubSeries get(Long id);
    SubSeries update(SubSeries subSeries);
}
