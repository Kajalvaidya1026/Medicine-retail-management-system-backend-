package com.deesha.medicine_distribution.dto;

import com.deesha.medicine_distribution.model.CompanyAddress;
import com.deesha.medicine_distribution.model.CompanyAddress.AddressType;

public record CompanyAddressResponse(
        Long addressId,
        Integer companyId,
        AddressType addressType,
        String addressLine1,
        String addressLine2,
        String citiesId,
        String city,
        Integer districtId,
        String district,
        Integer stateId,
        String state,
        Integer countryId,
        String country,
        String pincode) {

    /** Call inside a transaction or after a JOIN FETCH query. */
    public static CompanyAddressResponse from(CompanyAddress a) {
        var city = a.getCity();
        var district = city.getDistrict();
        var state = district.getState();
        var country = state.getCountry();
        return new CompanyAddressResponse(
                a.getAddressId(),
                a.getCompany().getCompanyId(),
                a.getAddressType(),
                a.getAddressLine1(),
                a.getAddressLine2(),
                city.getCitiesId(), city.getCityName(),
                district.getDistrictId(), district.getDistrictName(),
                state.getStateId(), state.getStateName(),
                country.getCountryId(), country.getCountryName(),
                a.getPincode());
    }
}
