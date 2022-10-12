package com.code.userservice.repository;

import com.code.userservice.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepos extends MongoRepository<Company,Integer>{

	Company save(Company com);

	@Query("{company_name:?0}")
	 List<Company> findByName(String company_name);

	@Query("{product_category:?0}")
	List<Company> findByProductCategory(String product_category);

}
