package com.deesha.medicine_distribution.controller;

import com.deesha.medicine_distribution.model.Companies;
import com.deesha.medicine_distribution.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comapany")
public class CompaniesController {

    @Autowired
    CompaniesService companiesService;

    @PostMapping("/save")
    public ResponseEntity saveCompany(@RequestBody Companies companies)
    {
        boolean saved = companiesService.saveCompanies(companies);
        {
            if(saved)
            {
                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity(saved, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

//    @GetMapping("/viewCompanies")
//    public List<Companies> getAllCompanies() throws Exception
//    {
//        List<Companies> list = companiesService.viewAllCompanies()
//        if(list.size()!=0)
//        {
//            System.out.println("  list ="+list.size());
//            return companiesService.viewAllCompanies();
//        }
//        else
//        {
//            throw new RuntimeException("There is No data In Database");
//        }
//    }
}