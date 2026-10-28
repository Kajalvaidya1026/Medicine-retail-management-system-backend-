//package com.deesha.medicine_distribution.controller;
//
//import com.deesha.medicine_distribution.dto.LocationDtos.*;
//import com.deesha.medicine_distribution.dto.CompanyAddressRequest;
//import com.deesha.medicine_distribution.dto.CompanyAddressResponse;
//import com.deesha.medicine_distribution.service.CompaniesAddressService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import java.net.URI;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/companies/{companyId}/addresses")
//@RequiredArgsConstructor
//public class CompanyAddressController {
//
//    private final CompaniesAddressService service;
//
//    @PostMapping
//    public ResponseEntity<CompanyAddressResponse> create(@PathVariable Integer companyId,
//                                                         @Valid @RequestBody CompanyAddressRequest request) {
////        CompanyAddressResponse created = service.saveCompanies(companyId, request);
//        CompanyAddressResponse created = service.addAddress(addressId, request);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(created.addressId()).toUri();
//
//        return service.create(companyId, req);
//    }
//
//    @GetMapping
//    public List<CompanyAddressResponse> list(@PathVariable Integer companyId) {
//        return service.list(companyId);
//    }
//
//    @GetMapping("/{addressId}")
//    public CompanyAddressResponse get(@PathVariable Integer companyId, @PathVariable Long addressId) {
//        return service.get(companyId, addressId);
//    }
//
//    @PutMapping("/{addressId}")
//    public CompanyAddressResponse update(@PathVariable Integer companyId,
//                                         @PathVariable Long addressId,
//                                         @Valid @RequestBody CompanyAddressRequest request) {
//        return service.update(companyId, addressId, request);
//    }
//
//    @DeleteMapping("/{addressId}")
//    public ResponseEntity<Void> delete(@PathVariable Integer companyId, @PathVariable Long addressId) {
//        service.delete(companyId, addressId);
//        return ResponseEntity.noContent().build();
//    }
//}