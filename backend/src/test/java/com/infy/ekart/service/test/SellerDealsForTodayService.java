package com.infy.ekart.service.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.infy.ekart.dao.SellerDealsForTodayDAO;
import com.infy.ekart.model.Product;
import com.infy.ekart.model.SellerDealsForToday;
//import com.infy.ekart.service.SellerDealsForTodayService;
import com.infy.ekart.service.SellerDealsForTodayServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerDealsForTodayService {
	
	@Mock
	private SellerDealsForTodayDAO sellerProductDAO;
	
	@InjectMocks 
	private SellerDealsForTodayServiceImpl sellerProductService=new SellerDealsForTodayServiceImpl();
	
	@Rule
	public ExpectedException expectedException=ExpectedException.none();
	
	@Test
	public <SellerDealForToday> void testAddNewProduct() throws Exception{
		SellerDealsForToday deal = new SellerDealsForToday();
		deal.setDealId(501040);
		
		Product product = new Product();
		product.setBrand("SangSung");
		product.setCategory("Electronics - Mobile");
		product.setDescription("Smart phone with 16MP rear camera and 8MP front camera, 6GB RAM and 32GB ROM,5.5 inch FHD display, Hi-Tech processor");
		product.setDiscount(7.0);
		product.setName("Dzire Plus");
		product.setPrice(15000.0);
		product.setProductId(1005);
		product.setQuantity(100);
		product.setSellerEmailId("jack@infosys.com");
		deal.setProduct(product);
		
		deal.setDealDiscount(25.0);
		deal.setDealStart(LocalDateTime.now());
		deal.setDealEnd(LocalDateTime.now().plusDays(1));
		deal.setSellerEmailId("jack@infosys.com");
		Mockito.when(sellerProductDAO.addNewDeal(deal)).thenReturn(1);
		Assert.assertNotNull(sellerProductService.addNewDeal(deal));
	    
	}
	
	@Test
	public void getProductsinDeals() throws Exception{
		List<SellerDealsForToday> s=new ArrayList<SellerDealsForToday>();
		SellerDealsForToday sd=new SellerDealsForToday();
		sd.setDealId(2);
		 sd.setSellerEmailId("abc@infosys.com");
		 s.add(sd);
//		 Assert.assertNotNull(sellerDealsForTodayDao.getProductsinDeals("abc@infosys.com"));
//		String email = "brad@infosys.com";
		Mockito.when(sellerProductService.getProductsinDeals("abc@infosys.com")).thenReturn(s);
		Assert.assertNotNull(sellerProductService.getProductsinDeals("abc@infosys.com"));
//		sellerProductService.getProductsinDeals(email);
	}
	
	@Test
	public void testRemoveProduct() throws Exception{
//		Mockito.when(sellerProductDAO.removeProductsFromDeals(Mockito.anyInt()).thenReturn(1);
//		Assert.assertNotNull(sellerProductService.removeProductsFromDeals(1);
	}
}
