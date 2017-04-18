package com.zx.dao;

import com.zx.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Credittone on 2017/4/11.
 */
public interface CompanyRepository extends JpaRepository<Company,Integer>{
    @Query("select p from Company p where p.company_name= :company_name")
    Company findByName(@Param("company_name") String companyName);
}
