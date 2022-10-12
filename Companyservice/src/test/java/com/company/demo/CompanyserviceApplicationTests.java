package com.company.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.*;
import com.company.demo.entities.Company;
import com.company.demo.repository.CompanyRepos;

@SpringBootTest
class CompanyserviceApplicationTests {

	/*@Autowired
	public CompanyRepos companyrepos;
	
	@Test
	void testcreatecoupons() {
		Company comp = new Company(118,"Flpkrt","Mumbai",{345,"25","Groceries",80});
		Company compsave = companyrepos.save(comp);
		assertThat(compsave.getCompany_id()).isEqualTo(118);
		
	}*/
	@Test
	void contextLoads() {
		
	}


}
