//package com.deesha.medicine_distribution.serviceImpl;
//
//import com.deesha.medicine_distribution.dto.LocationDtos.*;
//import com.deesha.medicine_distribution.dto.CompanyAddressRequest;
//import com.deesha.medicine_distribution.dto.CompanyAddressResponse;
//import com.deesha.medicine_distribution.model.Cities;
//import com.deesha.medicine_distribution.model.Companies;
//import com.deesha.medicine_distribution.model.CompanyAddress;
//import com.deesha.medicine_distribution.repository.CitiesRepository;
//import com.deesha.medicine_distribution.repository.CompaniesRepository;
//import com.deesha.medicine_distribution.repository.CompanyAddressRepository;
//import jakarta.persistence.EntityNotFoundException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CompanyAddressServiceImpl implements CompanyAddressService{
//
//    private final CompaniesRepository companiesRepository;
//    private final CitiesRepository citiesRepository;
//    private final CompanyAddressRepository addressRepository;
//
//    @Transactional
//    public CompanyAddressResponse create(Integer companyId, CompanyAddressRequest req) {
//        Companies company = companiesRepository.findById(companyId)
//                .orElseThrow(() -> new EntityNotFoundException("Company not found: " + companyId));
//
//        if (addressRepository.existsByCompanyCompanyIdAndAddressType(companyId, req.addressType())) {
//            throw new IllegalStateException(req.addressType() + " address already exists for this company");
//        }
//
//        CompanyAddress address = new CompanyAddress();
//        apply(address, req);
//        company.addAddress(address);          // sets both sides
//        addressRepository.saveAndFlush(address);
//
//        return CompanyAddressResponse.from(address);
//    }
//
////    @Transactional(readOnly = true)
////    public List<CompanyAddressResponse> list(Long companyId) {
////        if (!companiesRepository.existsById(companyId) {
////            throw new EntityNotFoundException("Company not found: " + companyId);
////        }
////        return addressRepository.findAllByCompany(companyId).stream()
////                .map(CompanyAddressResponse::from).toList();
////    }
//
//    @Transactional(readOnly = true)
//    public CompanyAddressResponse get(Integer companyId, Long addressId) {
//        return CompanyAddressResponse.from(find(companyId, addressId));
//    }
//
//    @Transactional
//    public CompanyAddressResponse update(Integer companyId, Long addressId, CompanyAddressRequest req) {
//        CompanyAddress address = find(companyId, addressId);
//
//        if (address.getAddressType() != req.addressType()
//                && addressRepository.existsByCompanyCompanyIdAndAddressType(companyId, req.addressType())) {
//            throw new IllegalStateException(req.addressType() + " address already exists for this company");
//        }
//
//        apply(address, req);
//        addressRepository.saveAndFlush(address);
//        return CompanyAddressResponse.from(address);
//    }
//
//    @Transactional
//    public void delete(Integer companyId, Long addressId) {
//        CompanyAddress address = find(companyId, addressId);
//        address.getCompany().removeAddress(address);   // orphanRemoval deletes the row
//    }
//
//    private CompanyAddress find(Integer companyId, Long addressId) {
//        return addressRepository.findByCompanyAndId(companyId, addressId)
//                .orElseThrow(() -> new EntityNotFoundException(
//                        "Address " + addressId + " not found for company " + companyId));
//    }
//
//    private void apply(CompanyAddress a, CompanyAddressRequest req) {
//        Cities city = citiesRepository.findById(req.citiesId())
//                .orElseThrow(() -> new EntityNotFoundException("City not found: " + req.citiesId()));
//        a.setAddressType(req.addressType());
//        a.setAddressLine1(req.addressLine1().trim());
//        a.setAddressLine2(req.addressLine2() == null ? null : req.addressLine2().trim());
//        a.setCity(city);
//        a.setPincode(req.pincode());
//    }
//}
