package com.infy.ekart.dao;

import java.util.List;

import com.infy.ekart.model.SellerDealsForToday;

public interface SellerDealsForTodayDAO {
	
//	public Integer addProductToDeals(SellerDealsForToday deal);
	
//	public List<SellerDealsForToday> getDealsForToday(String sellerEmailId);
	
	public List<SellerDealsForToday> getProductsinDeals(String sellerEmailId);
	
	public Integer addNewDeal(SellerDealsForToday deal);
	
	public Integer removeProductsFromDeals(Integer dealId);

}
