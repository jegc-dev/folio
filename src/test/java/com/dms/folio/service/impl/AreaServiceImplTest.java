package com.dms.folio.service.impl;

import com.dms.folio.model.Area;
import com.dms.folio.repository.AreaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AreaServiceImplTest {

    @InjectMocks
    AreaServiceImpl service;

    @Mock
    AreaRepository repository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
    }

    @Test
    void list() {
        Pageable pageable = PageRequest.of(0, 10);

        List<Area> list = new ArrayList<Area>();
        Area sistemas = Area.builder()
                .id(1L)
                .code("S001")
                .name("Sistemas")
                .build();
        Area contabilidad = Area.builder()
                .id(2L)
                .code("C001")
                .name("Contabilidad")
                .build();

        list.add(sistemas);
        list.add(contabilidad);

        final Page<Area> page = new PageImpl<>(list.subList(0, 2), pageable, list.size());

        when(repository.findAll(any(Pageable.class))).thenReturn(page);

        List<Area> areas = service.list(10).stream().toList();

        assertEquals(2, areas.size());
        verify(repository, times(1)).findAll(any(Pageable.class));
    }

    @Test
    void get() {
    }

    @Test
    void testGet() {
    }

    @Test
    void update() {
    }

    @Test
    void addSubArea() {
    }
}