package com.dms.folio.controller;

import com.dms.folio.model.PointOfEntry;
import com.dms.folio.model.Response;
import com.dms.folio.service.impl.PointOfEntryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/pointofentry")
@RequiredArgsConstructor
public class PointOfEntryResource {

    private final PointOfEntryServiceImpl pointOfEntryService;

    @GetMapping("/list")
    public ResponseEntity<Response> getPointOfEntries() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("pointOfEntry", pointOfEntryService.list(10)))
                        .message("PointOfEntries retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePointOfEntry(@RequestBody @Valid PointOfEntry pointOfEntry) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("pointOfEntry", pointOfEntryService.create(pointOfEntry)))
                        .message("PointOfEntry created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPointOfEntry(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("pointOfEntry", pointOfEntryService.get(id)))
                        .message("PointOfEntry retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updatePointOfEntry(@RequestBody @Valid PointOfEntry pointOfEntry) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("pointOfEntry", pointOfEntryService.update(pointOfEntry)))
                        .message("PointOfEntry updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
