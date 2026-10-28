package com.deesha.medicine_distribution.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

@Entity
@Table(name = "company_bank_account")
public class CompanyBankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_account_id")
    private Long bankAccountId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Companies company;

    @Column(name = "bank_name", nullable = false, length = 90)
    private String bankName;

    @Column(name = "bank_account_name", nullable = false, length = 90)
    private String accountName;

    @Column(name = "bank_account_number", unique = true, nullable = false, length = 18)
    @Pattern(regexp = "^[0-9]{9,18}$")
    private String accountNumber;

    // Not unique: many accounts can share the same IFSC (same branch)
    @Column(name = "ifsc_code", nullable = false, length = 11)
    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$")
    private String ifscCode;

    @Column(name = "branch_name", length = 90)
    private String branchName;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}