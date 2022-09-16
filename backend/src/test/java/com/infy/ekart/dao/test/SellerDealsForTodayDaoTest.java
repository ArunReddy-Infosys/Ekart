package com.infy.ekart.dao.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.infy.ekart.dao.SellerDealsForTodayDAO;
import com.infy.ekart.entity.ProductCategoryEntity;
import com.infy.ekart.entity.SellerDealsForTodayEntity;
import com.infy.ekart.model.Product;
import com.infy.ekart.model.Seller;
import com.infy.ekart.model.SellerDealsForToday;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class SellerDealsForTodayDaoTest {



		@Autowired
		private SellerDealsForTodayDAO sellerDealsForTodayDao;

		@Test
		public void addNewDeal()
		{
			Product prod = new Product();
			List<SellerDealsForToday> newDeals = new ArrayList<>();
			SellerDealsForToday deal = new SellerDealsForToday();
			deal.setDealDiscount(20.0);
			deal.setSellerEmailId("jack@infosys.com");
			
			Product product = new Product();
			product.setBrand("SangSung");
			product.setCategory("Electronics - Mobile");
			product.setDescription("Smart phone with 16MP rear camera and 8MP front camera, 6GB RAM and 32GB ROM,5.5 inch FHD display, Hi-Tech processor");
			product.setDiscount(7.0);
			product.setName("Dzire Plus");
			product.setPrice(15000.0);
			product.setProductId(1004);
			product.setQuantity(100);
			product.setSellerEmailId("jack@infosys.com");
			deal.setProduct(product);
			
			deal.setDealStart(LocalDateTime.now());
			deal.setDealEnd(LocalDateTime.now().plusDays(1));
			newDeals.add(deal);
			sellerDealsForTodayDao.addNewDeal(deal);
			Assert.assertTrue(true);
//			SellerDealsForToday s= new SellerDealsForToday();
//			
//			s.setDealId(501043);
//			Product p=new Product();
//			p.setBrand("Nivi");
//			p.setCategory("Sports");
//			p.setDescription("Volleyball, weight-300g");
//			p.setName("Nivi Volleyball");
//			p.setQuantity(550);
//			p.setPrice(500.00);
//			p.setDiscount(5.0);
//			p.setSellerEmailId("charles@infosys.com");
//			p.setProductId(1009);
//			s.setProduct(p);
//			
//			s.setDealDiscount(25.00);
//			s.setDealEnd(LocalDateTime.of(2020,11,11,23,00));
//			s.setDealStart(LocalDateTime.of(2020,11,11,23,00));
//			s.setSellerEmailId("charles@infosys.com");
//			
//			
////			lst.add(s);
//			sellerDealsForTodayDao.addNewDeal(s);
//			Assert.assertTrue(true);
		}
		
		@Test
		public void removeProduct(){
			SellerDealsForToday s=new SellerDealsForToday();
			s.setDealId(1);
			Assert.assertNotNull(sellerDealsForTodayDao.removeProductsFromDeals(s.getDealId()));
//			SellerDealsForToday s= new SellerDealsForToday();
//			List<SellerDealsForToday> lst=new ArrayList<SellerDealsForToday>();
//			Product p=new Product();
//			s.setDealDiscount(25.00);
//			s.setDealEnd(LocalDateTime.of(2020,11,11,3,00));
//			s.setDealStart(LocalDateTime.of(2020,11,11,23,00));
//			s.setSellerEmailId("charles@infosys.com");
//			p.setBrand("Nivi");
//			p.setCategory("Sports");
//			p.setDescription("Volleyball, weight-300g");
//			p.setName("Nivi Volleyball");
//			p.setQuantity(550);
//			p.setPrice(500.0);
//			p.setDiscount(5.0);
//			s.setProduct(p);
//			lst.add(s);
//			sellerDealsForTodayDao.removeProductsFromDeals(s.getDealId());
//			Assert.assertTrue(true);
		}
		
		@Test
		public void getProductsInDeal() {
			List<SellerDealsForToday> s=new ArrayList<>();
			SellerDealsForToday sd=new SellerDealsForToday();
			 sd.setSellerEmailId("abc@infosys.com");
			 s.add(sd);
			 Assert.assertNotNull(sellerDealsForTodayDao.getProductsinDeals("abc@infosys.com"));
//			sellerDealsForTodayDao.getProductsinDeals("brad@infosys.com");
		}
}
