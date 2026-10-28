package com.deesha.medicine_distribution.controller;

import com.deesha.medicine_distribution.dto.LocationDtos;
import com.deesha.medicine_distribution.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService service;

    @PostMapping
    public ResponseEntity<LocationDtos.CountryResponse> create(@Valid @RequestBody LocationDtos.CountryRequest req) {
        LocationDtos.CountryResponse created = service.create(req);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.countryId()).toUri()).body(created);
    }

    @GetMapping
    public List<LocationDtos.CountryResponse> list() { return service.list(); }

    @GetMapping("/{id}")
    public LocationDtos.CountryResponse get(@PathVariable Integer id) { return service.get(id); }

    @PutMapping("/{id}")
    public LocationDtos.CountryResponse update(@PathVariable Integer id, @Valid @RequestBody LocationDtos.CountryRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

