package com.dms.folio.controller;

import com.dms.folio.model.Area;
import com.dms.folio.model.Response;
import com.dms.folio.service.impl.AreaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/area")
@RequiredArgsConstructor
public class AreaResource {

    private final AreaServiceImpl areaService;

    @GetMapping("/list")
    public ResponseEntity<Response> getAreas() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("area", areaService.list(10)))
                        .message("Areas retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveArea(@RequestBody @Valid Area area) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("area", areaService.create(area)))
                        .message("Area created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getArea(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("area", areaService.get(id)))
                        .message("Area retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateArea(@RequestBody @Valid Area area) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("area", areaService.update(area)))
                        .message("Area updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
