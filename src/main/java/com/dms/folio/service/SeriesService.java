package com.dms.folio.service;


import com.dms.folio.model.Series;

import java.util.Collection;

public interface SeriesService {

    Series create(Series Series);
    Collection<Series> list(int limit);
    Series get(Long id);
    Series update(Series Series);
}
