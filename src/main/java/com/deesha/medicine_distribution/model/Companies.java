package com.deesha.medicine_distribution.model;

import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Companies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;

    // JOIN: companies -> enterprice_type
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_type_id")
    private EnterpriseType enterpriseType;

    // JOIN: companies -> company_address (one company, many addresses)
    @ToString.Exclude
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyAddress> addresses = new ArrayList<>();

    // JOIN: companies -> company_bank_account (one company, many accounts)
    @ToString.Exclude
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyBankAccount> bankAccounts = new ArrayList<>();

    @Column(name = "company_name", length = 90)
    private String companyName;

    @Column(name = "company_tradename", length = 90)
    private String companyTradeName;

    @Column(name = "company_cin", length = 20)
    private String companyCin;

    @Column(name = "manufacturing_license_no", length = 30)
    private String manufacturingLicenseNo;

    @Column(name = "drug_license_expiry_date")
    private LocalDate drugLicenseExpiryDate;

    @Column(name = "company_start_date")
    private LocalDate companyStartDate;

    @Column(name = "company_end_date")
    private LocalDate companyEndDate;

    @Column(name = "udyam_registration_no", length = 90)
    private String udyamRegistrationNo;

    @Column(name = "gstin", length = 15)
    private String gstin;

    @Column(name = "pan_number", length = 90)
    private String panNumber;

    @Column(name = "company_owner", length = 90)
    private String companyOwner;

    @Column(name = "owner_contact", length = 15)
    private String ownerContact;

    @Column(name = "owner_alternate_contact", length = 15)
    private String ownerAlternateContact;

    @Column(name = "authorized_signatory_name", length = 100)
    private String authorizedSignatoryName;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "alternate_contact", length = 15)
    private String alternateContact;

    @Column(name = "email_id", length = 100)
    private String emailId;

    @Column(name = "website", length = 150)
    private String website;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_by", length = 100)
    private String modifiedBy;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "deleted_by", length = 90)
    private String deletedBy;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

//     Helpers keep both sides of the relationship in sync
    public void addAddress(CompanyAddress address) {
        addresses.add(address);
        address.setCompany(this);
    }

    public void removeAddress(CompanyAddress address) {
        addresses.remove(address);
        address.setCompany(null);
    }

    public void addBankAccount(CompanyBankAccount account) {
        bankAccounts.add(account);
        account.setCompany(this);
    }

    public void removeBankAccount(CompanyBankAccount account) {
        bankAccounts.remove(account);
        account.setCompany(null);
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public List<CompanyAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CompanyAddress> addresses) {
        this.addresses = addresses;
    }

    public List<CompanyBankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<CompanyBankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyTradeName() {
        return companyTradeName;
    }

    public void setCompanyTradeName(String companyTradeName) {
        this.companyTradeName = companyTradeName;
    }

    public String getCompanyCin() {
        return companyCin;
    }

    public void setCompanyCin(String companyCin) {
        this.companyCin = companyCin;
    }

    public String getManufacturingLicenseNo() {
        return manufacturingLicenseNo;
    }

    public void setManufacturingLicenseNo(String manufacturingLicenseNo) {
        this.manufacturingLicenseNo = manufacturingLicenseNo;
    }

    public LocalDate getDrugLicenseExpiryDate() {
        return drugLicenseExpiryDate;
    }

    public void setDrugLicenseExpiryDate(LocalDate drugLicenseExpiryDate) {
        this.drugLicenseExpiryDate = drugLicenseExpiryDate;
    }

    public LocalDate getCompanyStartDate() {
        return companyStartDate;
    }

    public void setCompanyStartDate(LocalDate companyStartDate) {
        this.companyStartDate = companyStartDate;
    }

    public LocalDate getCompanyEndDate() {
        return companyEndDate;
    }

    public void setCompanyEndDate(LocalDate companyEndDate) {
        this.companyEndDate = companyEndDate;
    }

    public String getUdyamRegistrationNo() {
        return udyamRegistrationNo;
    }

    public void setUdyamRegistrationNo(String udyamRegistrationNo) {
        this.udyamRegistrationNo = udyamRegistrationNo;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getCompanyOwner() {
        return companyOwner;
    }

    public void setCompanyOwner(String companyOwner) {
        this.companyOwner = companyOwner;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public String getOwnerAlternateContact() {
        return ownerAlternateContact;
    }

    public void setOwnerAlternateContact(String ownerAlternateContact) {
        this.ownerAlternateContact = ownerAlternateContact;
    }

    public String getAuthorizedSignatoryName() {
        return authorizedSignatoryName;
    }

    public void setAuthorizedSignatoryName(String authorizedSignatoryName) {
        this.authorizedSignatoryName = authorizedSignatoryName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAlternateContact() {
        return alternateContact;
    }

    public void setAlternateContact(String alternateContact) {
        this.alternateContact = alternateContact;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}