package com.deesha.medicine_distribution.controller;

import com.deesha.medicine_distribution.dto.LocationDtos.*;
import com.deesha.medicine_distribution.service.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService service;

    @PostMapping
    public ResponseEntity<CityResponse> create(@Valid @RequestBody CityRequest req) {
        CityResponse created = service.create(req);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.citiesId()).toUri()).body(created);
    }

    @GetMapping
    public List<CityResponse> list(@RequestParam(required = false) Integer districtId) {
        return service.list(districtId);
    }

    @GetMapping("/{id}")
    public CityResponse get(@PathVariable String id) { return service.get(id); }

    @PutMapping("/{id}")
    public CityResponse update(@PathVariable String id, @Valid @RequestBody CityRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}