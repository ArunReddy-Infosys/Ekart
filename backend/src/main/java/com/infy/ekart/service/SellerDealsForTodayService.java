package com.infy.ekart.service;

import java.util.List;

import com.infy.ekart.model.Product;
import com.infy.ekart.model.SellerDealsForToday;

public interface SellerDealsForTodayService {
	public Integer addNewDeal(SellerDealsForToday deal) throws Exception;
	
	public List<SellerDealsForToday> getProductsinDeals(String sellerEmailId) throws Exception;
	
	public void removeProductsFromDeals(Integer dealId)throws Exception;

}
