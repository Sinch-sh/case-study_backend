package com.code.userservice.service;

import com.code.userservice.entity.Company;
import com.code.userservice.repository.CompanyRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class Compservice {
	
	
	@Autowired
	public CompanyRepos companyrepos;
	
	public ResponseEntity<?> servicecreatecoupons(Company com)
	{
		try {
			
			Company savedcomp = this.companyrepos.save(com);
			return new ResponseEntity<>("Added successfully",HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<String> servicedeleteCouponsBycompanyId(int company_id){
	companyrepos.deleteById(company_id);
	return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
	
	public List<Company> servicegettotalorders() {
		return companyrepos.findAll();
		}
	
	
	public ResponseEntity<?> serviceupdateById(Company company,int company_id){
		Optional<Company> comp= companyrepos.findById(company_id);
		try {
		if(comp.isPresent()) {
			company.setId(String.valueOf(company_id));
	        companyrepos.save(company);
	        //return company;
	        return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
		
			} 
			else {
				return new ResponseEntity<>("Record Not found",HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public List<?> servicegetCouponByCompanyName(String company_name) {
		
		return companyrepos.findByName(company_name);}
	
	
	public List<?> servicegetCouponByProductCategory(String product_category) {
		
		return companyrepos.findByProductCategory(product_category);}
	
}
