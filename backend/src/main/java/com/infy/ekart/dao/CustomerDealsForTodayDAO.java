package com.infy.ekart.dao;

import java.util.List;

import com.infy.ekart.model.SellerDealsForToday;

public interface CustomerDealsForTodayDAO {
	
	public List<SellerDealsForToday> getAllDealsForCustomer();

}
