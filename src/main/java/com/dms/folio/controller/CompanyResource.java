package com.dms.folio.controller;

import com.dms.folio.model.Company;
import com.dms.folio.model.Response;
import com.dms.folio.service.impl.CompanyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyResource {

    private final CompanyServiceImpl companyService;

    @GetMapping("/list")
    public ResponseEntity<Response> getCompanies() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("companies", companyService.list(10)))
                        .message("Companies retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCompany(@RequestBody @Valid Company company) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("company", companyService.create(company)))
                        .message("Company created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCompany(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("company", companyService.get(id)))
                        .message("Company retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateCompany(@RequestBody @Valid Company company) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("company", companyService.update(company)))
                        .message("Company updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
