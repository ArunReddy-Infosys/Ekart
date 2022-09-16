package com.infy.ekart.service;

import java.util.List;

import com.infy.ekart.model.SellerDealsForToday;

public interface CustomerDealsForTodayService {

	public List<SellerDealsForToday> getAllDealsForCustomer() throws Exception;
}
