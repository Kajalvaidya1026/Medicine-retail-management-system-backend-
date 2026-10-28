package com.deesha.medicine_distribution.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cities")
public class Cities {
    @Id
    @Column(name = "cities_id")
    private String citiesId;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private Districts district;

    public String getCitiesId() {
        return citiesId;
    }

    public void setCitiesId(String citiesId) {
        this.citiesId = citiesId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Districts getDistrict() {
        return district;
    }

    public void setDistrict(Districts district) {
        this.district = district;
    }
}