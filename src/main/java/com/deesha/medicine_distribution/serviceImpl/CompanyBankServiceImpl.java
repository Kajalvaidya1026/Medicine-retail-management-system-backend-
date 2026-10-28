package com.deesha.medicine_distribution.serviceImpl;

import com.deesha.medicine_distribution.model.CompanyBankAccount;
import com.deesha.medicine_distribution.model.UserModel;
import com.deesha.medicine_distribution.service.CompanyBankService;

import java.util.List;

public class CompanyBankServiceImpl implements CompanyBankService {
    @Override
    public boolean saveBankDetails(CompanyBankAccount companyBankAccount) {
        return false;
    }

    @Override
    public List<UserModel> viewAllDetails() {
        return List.of();
    }
}
