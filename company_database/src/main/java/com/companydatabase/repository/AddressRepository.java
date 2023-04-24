package com.companydatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companydatabase.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
