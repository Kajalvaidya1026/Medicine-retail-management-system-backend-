package com.deesha.medicine_distribution.dto;

import com.deesha.medicine_distribution.model.CompanyAddress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CompanyAddressRequest(
        @NotNull CompanyAddress.AddressType addressType,
        @NotBlank @Size(max = 255) String addressLine1,
        @Size(max = 255) String addressLine2,
        @NotBlank String citiesId,
        @NotBlank @Pattern(regexp = "\\d{6}", message = "pincode must be 6 digits") String pincode)
        {}
