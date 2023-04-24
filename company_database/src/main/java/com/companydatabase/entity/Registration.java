package com.companydatabase.entity;

import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "registration")
public class Registration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "registration_id", columnDefinition = "BINARY(16)")
    private UUID registrationId;

    @Column(name="id")
    private Long id;
    
    @Column(name = "legal_name")
    private String legalName;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "dor")
    private LocalDate DOR;
   

    @OneToOne(mappedBy = "registration")
    @JsonBackReference
    private Company company;
    
		public UUID getRegistrationId() {
			return registrationId;
		}


		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

		public void setRegistrationId(UUID registrationId) {
			this.registrationId = registrationId;
		}

		public String getLegalName() {
			return legalName;
		}

		public void setLegalName(String legalName) {
			this.legalName = legalName;
		}

		public LocalDate getDOR() {
			return DOR;
		}

		public void setDOR(LocalDate dOR) {
			DOR = dOR;
		}
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		

		public Registration(UUID registrationId, Long id, String legalName, LocalDate dOR ,Company company) {
			super();
			this.registrationId = registrationId;
			this.id = id;
			this.legalName = legalName;
			DOR = dOR;
			this.company = company;
		}

		public Registration() {
			super();
		}
		
	    
	    
	}
