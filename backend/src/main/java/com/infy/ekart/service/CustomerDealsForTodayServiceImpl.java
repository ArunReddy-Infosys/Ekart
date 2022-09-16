package com.infy.ekart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.ekart.dao.CustomerDealsForTodayDAO;
import com.infy.ekart.model.SellerDealsForToday;

@Service(value="customerDealsForTodayService")
@Transactional
public class CustomerDealsForTodayServiceImpl implements CustomerDealsForTodayService {
	
	@Autowired
	private CustomerDealsForTodayDAO customerDealsForTodayDAO;
	
	@Override
	public List<SellerDealsForToday> getAllDealsForCustomer() throws Exception{
		List <SellerDealsForToday> sellerDealsForToday=null;
		sellerDealsForToday = customerDealsForTodayDAO.getAllDealsForCustomer();
		return sellerDealsForToday;
	}

}
