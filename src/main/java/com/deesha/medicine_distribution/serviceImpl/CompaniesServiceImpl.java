package com.deesha.medicine_distribution.serviceImpl;

import com.deesha.medicine_distribution.model.Companies;
import com.deesha.medicine_distribution.model.UserModel;
import com.deesha.medicine_distribution.service.CompaniesService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompaniesServiceImpl implements CompaniesService {
    @Override
    public boolean saveCompanies(Companies companies) {
        return false;
    }

    @Override
    public List<UserModel> viewAllCompanies() {
        return List.of();
    }
}
