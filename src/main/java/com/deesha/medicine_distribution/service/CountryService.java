package com.deesha.medicine_distribution.service;

import com.deesha.medicine_distribution.dto.LocationDtos;
import java.util.List;

public interface CountryService {

    public LocationDtos.CountryResponse create(LocationDtos.CountryRequest r);

    public List<LocationDtos.CountryResponse> list();

    public LocationDtos.CountryResponse get(Integer id);

    public LocationDtos.CountryResponse update(Integer id, LocationDtos.CountryRequest r);

    public void delete(Integer id);
}
