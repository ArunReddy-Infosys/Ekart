package com.infy.ekart.service;
import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.ekart.dao.SellerDealsForTodayDAO;
import com.infy.ekart.model.SellerDealsForToday;
import com.infy.ekart.validator.DealsValidator;

@Transactional
@Service(value="sellerDealsForTodayService")
public class SellerDealsForTodayServiceImpl implements SellerDealsForTodayService {
	
	@Autowired
	SellerDealsForTodayDAO sellerDealsForTodayDAO;
	
	@Override
	public List<SellerDealsForToday> getProductsinDeals(String sellerEmailId) throws Exception
	{
		List<SellerDealsForToday> lst=sellerDealsForTodayDAO.getProductsinDeals(sellerEmailId);
		if(!lst.isEmpty())
			return lst;
		else
			throw new Exception("SellerDealsForTodayService.NO_PRODUCTS_ADDED_TO_DEALS");
	}
	
	@Override
	public Integer addNewDeal(SellerDealsForToday deal) throws Exception
	{
		
		DealsValidator.validateDeals(deal);
		Integer dealId = sellerDealsForTodayDAO.addNewDeal(deal);
		return dealId;
			
			
	}
	
	@Override
	public void removeProductsFromDeals(Integer dealId) throws Exception{
		if(sellerDealsForTodayDAO.removeProductsFromDeals(dealId)!=-1) {
			throw new Exception("No such item");
		}
		
	}
	
}
