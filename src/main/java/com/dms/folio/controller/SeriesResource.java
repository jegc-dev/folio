package com.dms.folio.controller;

import com.dms.folio.model.Series;
import com.dms.folio.model.Response;
import com.dms.folio.service.impl.SeriesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesResource {

    private final SeriesServiceImpl seriesService;

    @GetMapping("/list")
    public ResponseEntity<Response> getSeries() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("series", seriesService.list(10)))
                        .message("Seriess retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveSeries(@RequestBody @Valid Series series) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("series", seriesService.create(series)))
                        .message("Series created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getSeries(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("series", seriesService.get(id)))
                        .message("Series retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateSeries(@RequestBody @Valid Series series) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("series", seriesService.update(series)))
                        .message("Series updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
