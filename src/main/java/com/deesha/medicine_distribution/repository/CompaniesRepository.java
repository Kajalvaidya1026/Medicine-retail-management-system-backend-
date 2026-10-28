package com.deesha.medicine_distribution.repository;

import com.deesha.medicine_distribution.model.Companies;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompaniesRepository extends JpaRepository<Companies,Integer> {

}