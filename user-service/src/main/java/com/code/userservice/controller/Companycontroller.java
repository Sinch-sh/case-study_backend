//package com.code.userservice.controller;
//
//import com.code.userservice.entity.Company;
//import com.code.userservice.service.Compservice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/mapcontroller")
//public class Companycontroller {
//
//
//	@Autowired
//	public Compservice companyservice;
//
//	@Bean
//	public Compservice companyservice()
//	{
//		return new Compservice();
//	}
//
//	@PostMapping("/create")
//	public ResponseEntity<?> createcoupons(@RequestBody Company com)
//	{
//			return companyservice.servicecreatecoupons(com);
//	}
//
//	@DeleteMapping("deleteProductsbyId/{id}")
//	public ResponseEntity<String> deleteCouponsBycompanyId(@PathVariable("id") int company_id){
//		return companyservice.servicedeleteCouponsBycompanyId(company_id);
//	}
//
//	@GetMapping("/getAlldetails")
//	public List<Company> gettotalorders() {
//		return companyservice.servicegettotalorders();
//		}
//
//
//
//
//	@PutMapping("/updateById/{company_id}")
//	public ResponseEntity<?> updateById(@RequestBody Company company,@PathVariable("company_id") int company_id){
//
//		return companyservice.serviceupdateById(company, company_id);
//	}
//
//	@GetMapping("/getByCompanyName/{company_name}")
//	public List<?> getCouponByCompanyName(@PathVariable("company_name") String company_name) {
//
//					return companyservice.servicegetCouponByCompanyName(company_name);}
//	              /* List<Company>  companyresponse =
//	               if(!companyresponse.isEmpty())
//	               {
//	            	   return companyresponse;
//	               }
//	               else
//	               {
//	            	   String response = "Record_Not_Found";
//	            	   List<?> finalresponse = Arrays.asList(response);
//	            	   return finalresponse;
//	               }
//	}*/
//	/*@PutMapping("updatebyid/{id}")
//	public ResponseEntity<String> updateById(@PathVariable int id) {
//		return new ResponseEntity<String>(companyrepos.updateById(id)+" record(s) updated.", HttpStatus.OK);
//	}*/
//
//	@GetMapping("/productcategory/{product_category}")
//	public List<?> getCouponByProductCategory(@PathVariable("product_category") String product_category) {
//
//		return companyservice.servicegetCouponByProductCategory(product_category);}
//		/* List<Company>  product_category_response = companyrepos.findByProductCategory(product_category);
//		 if(!product_category_response.isEmpty())
//         {
//      	   return product_category_response;
//         }
//		 else {
//			 String category_response = "Record_Not_Found";
//			 List<?> final_category_response = Arrays.asList(category_response);
//      	   	return final_category_response;
//		 }
//
//	}*/
//
//}
