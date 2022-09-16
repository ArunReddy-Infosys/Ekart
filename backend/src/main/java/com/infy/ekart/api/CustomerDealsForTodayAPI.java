package com.infy.ekart.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.ekart.service.CustomerDealsForTodayService;

import com.infy.ekart.model.SellerDealsForToday;


@CrossOrigin
@RestController
@RequestMapping("CustomerDealsForTodayAPI")

public class CustomerDealsForTodayAPI {

	@Autowired
	private CustomerDealsForTodayService customerDealsForTodayService;
	@Autowired
	private Environment environment;
	@GetMapping(value="getAllDealsForCustomer")
	public ResponseEntity<List<SellerDealsForToday>> getAllDealsForCustomer() throws Exception{
		List<SellerDealsForToday> dealsList=null;
		try {
			dealsList=customerDealsForTodayService.getAllDealsForCustomer();
			return new ResponseEntity<List<SellerDealsForToday>>(dealsList,HttpStatus.OK); 
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
}
