package com.code.userservice.controller;

import com.code.userservice.entity.Company;
import com.code.userservice.service.Compservice;
import com.code.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
   private Compservice compservice;
    @Bean
	public Compservice compservice()
	{
		return new Compservice();
	}



    @PostMapping("/add")
    public ResponseEntity<?> createCoupon(@RequestBody Company com) {
        try {
            ResponseEntity<?> company = compservice.servicecreatecoupons(com);
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("User could not be added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAllUser")
    public List<Company> getUser() {

        return compservice.servicegettotalorders();
    }

    @GetMapping("list/{name}")
    public ResponseEntity <Object> getUserById(@PathVariable String name) {
        try {
            return ResponseEntity.ok().body(compservice.servicegetCouponByCompanyName(name));
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("User not found with id"+name,HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/login/{name}/{password}")
//    public ResponseEntity<Object> login(@PathVariable String name,@PathVariable String password)
//    {
//        try{
//            return ResponseEntity.ok().body(userService.Login(name, password));
//        }
//        catch(Exception e)
//        {
//            return new ResponseEntity<>("User not found with name"+name,HttpStatus.NOT_FOUND);
//        }
//
//    }


    @PutMapping("/update/{company_id}")
    public ResponseEntity < Object > updateSupplier(@PathVariable int company_id, @RequestBody Company company) {
        try {
            company.setId(String.valueOf(company_id));
            return ResponseEntity.ok().body(compservice.serviceupdateById(company,company_id));
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("User not found with id"+company_id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable int company_id)  {
        try {
            compservice.servicedeleteCouponsBycompanyId(company_id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("User not found with id"+company_id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}