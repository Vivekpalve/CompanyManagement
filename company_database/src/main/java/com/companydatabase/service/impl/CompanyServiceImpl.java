package com.companydatabase.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.companydatabase.entity.Company;
import com.companydatabase.entity.Users;
import com.companydatabase.repository.CompanyRepository;
import com.companydatabase.request.CompanyRequest;
import com.companydatabase.response.CompanyResponse;
import com.companydatabase.service.CompanyService;
import com.companydatabase.transformer.RequestConverter;
import com.companydatabase.transformer.ResponceConverter;


@Service
public class CompanyServiceImpl implements CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;
  
    @Override
   
    public List<CompanyResponse> getAllCompanies() {
        try {
            List<Company> companies = companyRepository.findAll();
            return companies.stream().map(ResponceConverter::convertToResponse).collect(Collectors.toList());
        } catch (Exception e) {
             return Collections.emptyList();
        	
        }
    }

    @Override
    public Optional<CompanyResponse> getCompanyById(Long companyId) {
        try {
            Optional<Company> companyOptional = companyRepository.findById(companyId);
            if (companyOptional.isPresent()) {
                CompanyResponse companyResponse = ResponceConverter.convertToResponse(companyOptional.get());
                return Optional.of(companyResponse);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    
    @Override
    public String updateCompany(Long companyId, CompanyRequest companyRequest) {
        try {
            Optional<Company> optionalCompany = companyRepository.findById(companyId);
            if (optionalCompany.isPresent()) {
                Company company = optionalCompany.get();
                RequestConverter.updateEntity(company, companyRequest);
                companyRepository.save(company);
                return "Company updated successfully.";
            } else {
                return "Company not found.";
            }
        } catch (Exception e) {
            return "Error occurred at the time of updating.";
        }
    }


    @Override
    public String deleteCompany(Long companyId) {
        try {
            Optional<Company> optionalCompany = companyRepository.findById(companyId);
            if (optionalCompany.isPresent()) {
                Company company = optionalCompany.get();

                // Set isDeleted flag for all users belonging to the company
                for (Users user : company.getUsers()) {
                    user.setDeleted(true);
                }

                company.setIsDeleted(true); 
                companyRepository.save(company);
                return "Company deleted successfully.";
            } else {
                return "Company not found.";
            }
        } catch (Exception e) {
            return "Error occurred at the time of deleting.";
        }
    }

	
//create company
	@Override
	public CompanyResponse createCompany(CompanyRequest companyRequest) {		
		Company company = RequestConverter.toEntity(companyRequest);
		Company com = this.companyRepository.save(company);
		return ResponceConverter.convertToResponse(com);
		
	}

}
	


	


