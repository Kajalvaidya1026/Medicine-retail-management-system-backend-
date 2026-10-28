package com.deesha.medicine_distribution.service;

import com.deesha.medicine_distribution.dto.CompanyAddressRequest;
import com.deesha.medicine_distribution.model.UserModel;
import java.util.List;

public interface CompaniesAddressService  {

    public Long addAddress(Long companyId, CompanyAddressRequest req);
    List<UserModel> viewcompanyAddress();
}
