package com.companydatabase.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.companydatabase.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {
    List<Registration> findAll();

}
