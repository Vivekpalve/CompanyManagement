package com.companydatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companydatabase.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	
}
