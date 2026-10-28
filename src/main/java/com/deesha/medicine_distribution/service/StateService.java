package com.deesha.medicine_distribution.service;

import com.deesha.medicine_distribution.dto.LocationDtos;
import java.util.List;

public interface StateService {

    public LocationDtos.StateResponse create(LocationDtos.StateRequest r);

    public List<LocationDtos.StateResponse> list(Integer countryId);

    public LocationDtos.StateResponse get(Integer id);

    public LocationDtos.StateResponse update(Integer id, LocationDtos.StateRequest r);

    public void delete(Integer id);
}
