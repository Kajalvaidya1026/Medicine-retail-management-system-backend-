package com.deesha.medicine_distribution.repository;

import com.deesha.medicine_distribution.model.CompanyBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyBankRepository extends JpaRepository<CompanyBankAccount, Long> {
}
