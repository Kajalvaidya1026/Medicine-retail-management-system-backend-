package com.deesha.medicine_distribution.service;

import com.deesha.medicine_distribution.dto.LocationDtos;
import com.deesha.medicine_distribution.model.Cities;
import jakarta.validation.Valid;

import java.util.List;

public interface CityService {

    public LocationDtos.CityResponse create(LocationDtos.CityRequest r);

    public List<LocationDtos.CityResponse> list(Integer districtId);

    public LocationDtos.CityResponse get(String id);

    public void delete(String id);

    LocationDtos.CityResponse update(String id, LocationDtos.@Valid CityRequest req);
}
