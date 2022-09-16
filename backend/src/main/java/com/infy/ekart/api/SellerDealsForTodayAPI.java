package com.infy.ekart.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.ekart.model.SellerDealsForToday;
import com.infy.ekart.service.SellerDealsForTodayService;

@CrossOrigin
@RestController
@RequestMapping("sellerDealsForTodayAPI")
public class SellerDealsForTodayAPI {
	
	@Autowired
	SellerDealsForTodayService sellerDealsForTodayService;
	
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(SellerDealsForTodayAPI.class.getName());
	
	@PostMapping(value="getProductsinDeals")
	public ResponseEntity<List<SellerDealsForToday>> getProductsinDeals(@RequestBody String sellerEmailId)throws Exception{
		try {
			List<SellerDealsForToday> lst=sellerDealsForTodayService.getProductsinDeals(sellerEmailId);
			return new ResponseEntity<List<SellerDealsForToday>>(lst,HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
		
	}
	
	
	@PostMapping(value = "addNewDeal")
	public ResponseEntity<?> addNewDeal(@RequestBody SellerDealsForToday deal) throws Exception{
		try
		{
			Integer dealId= sellerDealsForTodayService.addNewDeal(deal);
			logger.info("Product in deal added successfully:");
			deal.setDealId(dealId);
			ResponseEntity<Integer> response=new ResponseEntity<Integer>(dealId,HttpStatus.OK);
			return response;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping(value="removeProductsFromDeals")
	public ResponseEntity<?> removeProductsFromDeals(@RequestBody Integer dealId) throws Exception{
		try {
			sellerDealsForTodayService.removeProductsFromDeals(dealId);
			ResponseEntity<Integer> response=new ResponseEntity<Integer>(dealId,HttpStatus.OK);
			return response;
			
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
