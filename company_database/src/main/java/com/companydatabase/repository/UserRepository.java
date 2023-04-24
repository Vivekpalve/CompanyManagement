package com.companydatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.companydatabase.entity.Users;


public interface UserRepository extends JpaRepository<Users , Long>{

	List<Users> findByCompany_CompanyId(Long companyId);


}
