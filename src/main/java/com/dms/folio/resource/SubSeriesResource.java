package com.dms.folio.resource;

import com.dms.folio.model.SubSeries;
import com.dms.folio.model.Response;
import com.dms.folio.service.impl.SubSeriesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/subSeries")
@RequiredArgsConstructor
public class SubSeriesResource {

    private final SubSeriesServiceImpl subSeriesService;

    @GetMapping("/list")
    public ResponseEntity<Response> getSubSeries() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("subSeries", subSeriesService.list(10)))
                        .message("SubSeriess retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveSubSeries(@RequestBody @Valid SubSeries subSeries) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("subSeries", subSeriesService.create(subSeries)))
                        .message("SubSeries created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getSubSeries(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("subSeries", subSeriesService.get(id)))
                        .message("SubSeries retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateSubSeries(@RequestBody @Valid SubSeries subSeries) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("subSeries", subSeriesService.update(subSeries)))
                        .message("SubSeries updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
