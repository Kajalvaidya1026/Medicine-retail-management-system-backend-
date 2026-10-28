package com.deesha.medicine_distribution.service;

import com.deesha.medicine_distribution.dto.LocationDtos;

import java.util.List;

import static java.nio.file.Files.find;

public interface DistrictService {

    public LocationDtos.DistrictResponse create(LocationDtos.DistrictRequest r);

    public List<LocationDtos.DistrictResponse> list(Integer stateId);

    public LocationDtos.DistrictResponse get(Integer id);

    public LocationDtos.DistrictResponse update(Integer id, LocationDtos.DistrictRequest r);

    public void delete(Integer id);
}
