package com.deesha.medicine_distribution.service;

import com.deesha.medicine_distribution.model.CompanyBankAccount;
import com.deesha.medicine_distribution.model.UserModel;

import java.util.List;

public interface CompanyBankService {
    boolean saveBankDetails(CompanyBankAccount companyBankAccount);
    List<UserModel> viewAllDetails();
}
