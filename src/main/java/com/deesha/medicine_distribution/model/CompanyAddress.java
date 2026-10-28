package com.deesha.medicine_distribution.model;

import jakarta.persistence.*;

@Entity
@Table(name = "company_address",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_company_address_type",
                columnNames = {"company_id", "address_type"}))
public class CompanyAddress {

    public enum AddressType { REGISTERED, FACTORY, CORRESPONDENCE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Companies company;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", nullable = false, length = 20)
    private AddressType addressType;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    // district, state, country are derived: city -> district -> state -> country
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cities_id", nullable = false)
    private Cities city;

    @Column(name = "pincode", nullable = false, length = 6)
    private String pincode;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}