package com.infy.ekart.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.ekart.entity.ProductEntity;
import com.infy.ekart.entity.SellerDealsForTodayEntity;
import com.infy.ekart.model.Product;
import com.infy.ekart.model.SellerDealsForToday;


@Repository(value="customerDealsForTodayDAO")
public class CustomerDealsForTodayDAOImpl implements CustomerDealsForTodayDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<SellerDealsForToday> getAllDealsForCustomer()
	{		
		Query query = entityManager.createQuery("select s from SellerDealsForTodayEntity s");
		List<SellerDealsForTodayEntity> DealsForTodayEntityList=query.getResultList();
		List<SellerDealsForToday> listOfDealProducts=new ArrayList<SellerDealsForToday>();	    
		for(SellerDealsForTodayEntity sellerDealsForTodayEntity:DealsForTodayEntityList)
	    {  
				String dealMessage;
	    		SellerDealsForToday dealsForToday=new SellerDealsForToday();
		    	
		    	dealsForToday.setDealId(sellerDealsForTodayEntity.getDealId());
		    	dealsForToday.setDealDiscount(sellerDealsForTodayEntity.getDealDiscount());
		    	dealsForToday.setDealStart(sellerDealsForTodayEntity.getDealStart());
		    	dealsForToday.setDealEnd(sellerDealsForTodayEntity.getDealEnd());
		    	dealsForToday.setSellerEmailId(sellerDealsForTodayEntity.getSellerEmailId());
		    	
		    	Product product =new Product();		    	
		    	product.setProductId(sellerDealsForTodayEntity.getProductEntity().getProductId());
		    	product.setName(sellerDealsForTodayEntity.getProductEntity().getName());
		    	product.setDescription(sellerDealsForTodayEntity.getProductEntity().getDescription());
		    	product.setBrand(sellerDealsForTodayEntity.getProductEntity().getBrand());
		    	product.setPrice(sellerDealsForTodayEntity.getProductEntity().getPrice());
		    	product.setDiscount(sellerDealsForTodayEntity.getProductEntity().getDiscount());
		    	product.setQuantity(sellerDealsForTodayEntity.getProductEntity().getQuantity());
		    	product.setCategory(sellerDealsForTodayEntity.getProductEntity().getCategory());
		    	product.setSellerEmailId(sellerDealsForTodayEntity.getProductEntity().getSellerEmailId());
		    	dealsForToday.setProduct(product);
		    		
		    	LocalDate startDate=dealsForToday.getDealStart().toLocalDate();
		    	LocalDate endDate=dealsForToday.getDealEnd().toLocalDate();
		    	LocalDate today=LocalDate.now();
		    	
		    	if((today.isAfter(startDate) && today.isBefore(endDate)) || (today.isEqual(startDate) || (today.isEqual(endDate))))
		    	{
//		    		System.out.println("1");
		    		if(dealsForToday.getDealEnd().isBefore(LocalDateTime.now())) 
		    			dealMessage="Deal Completed";		    		
		    		else if(dealsForToday.getDealStart().isBefore(LocalDateTime.now()) && dealsForToday.getDealEnd().isAfter(LocalDateTime.now())) 
		    			dealMessage="Deal Is On";
		    		else
		    			dealMessage="Deal Yet To Start";
		    	dealsForToday.setDealMessage(dealMessage);
//		    	System.out.println(dealsForToday.getDealMessage());
		    	listOfDealProducts.add(dealsForToday);
		    	
	    	}	    	
	    }	    		    
		
		return listOfDealProducts;
	}	


}
