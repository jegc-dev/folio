package com.dms.folio.controller;

import com.dms.folio.model.SubArea;
import com.dms.folio.model.Response;
import com.dms.folio.service.impl.SubAreaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/subarea")
@RequiredArgsConstructor
public class SubAreaResource {

    private final SubAreaServiceImpl subAreaService;

    @GetMapping("/list")
    public ResponseEntity<Response> getSubAreas() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("subArea", subAreaService.list(10)))
                        .message("SubAreas retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveSubArea(@RequestBody @Valid SubArea subArea) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("subArea", subAreaService.create(subArea)))
                        .message("SubArea created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getSubArea(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("subArea", subAreaService.get(id)))
                        .message("SubArea retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateSubArea(@RequestBody @Valid SubArea subArea) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("subArea", subAreaService.update(subArea)))
                        .message("SubArea updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
