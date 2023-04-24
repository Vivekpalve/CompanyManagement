package com.companydatabase.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.companydatabase.request.CompanyRequest;
import com.companydatabase.response.CompanyResponse;
import com.companydatabase.service.CompanyService;



@RestController
@RequestMapping("/companies")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;
    
    
    @PostMapping("/post")
    public ResponseEntity<CompanyResponse> createCompany(@RequestBody CompanyRequest companyRequest) {
        CompanyResponse response = companyService.createCompany(companyRequest);
        return ResponseEntity.ok(response);
    }
    
    
    @PutMapping("/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable Long companyId, @RequestBody CompanyRequest companyRequest) {
        String message = companyService.updateCompany(companyId, companyRequest);
        return ResponseEntity.ok(message);
    }
    
    
    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {
        List<CompanyResponse> response = companyService.getAllCompanies();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable Long companyId) {
        Optional<CompanyResponse> optionalCompany = companyService.getCompanyById(companyId);
        if (optionalCompany.isPresent()) {
            return ResponseEntity.ok(optionalCompany.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId) {
        String message = companyService.deleteCompany(companyId);
        return ResponseEntity.ok(message);
    }
	
}
