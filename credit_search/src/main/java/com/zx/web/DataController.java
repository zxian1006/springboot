package com.zx.web;

import com.zx.dao.CompanyRepository;
import com.zx.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Credittone on 2017/4/11.
 */
@RestController
public class DataController {

    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping("/findCompany")
    public Company findCompany(String company_name){
        Company companies = companyRepository.findByName(company_name);
        if(companies == null){
            companies.setBody("没有查到该公司!");
        }
        return companies;
    }
}
