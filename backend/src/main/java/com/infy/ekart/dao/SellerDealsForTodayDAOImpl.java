package com.infy.ekart.dao;

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


@Repository(value="sellerDealsForTodayDAO")
public class SellerDealsForTodayDAOImpl implements SellerDealsForTodayDAO {
	
	@Autowired
	EntityManager entityManager;

	
	@Override
	public List<SellerDealsForToday> getProductsinDeals(String sellerEmailId)
	{
//		System.out.println(sellerEmailId+"Hello");
		String s1="select s from SellerDealsForTodayEntity s where s.sellerEmailId = ?1";
//		System.out.println(sellerEmailId+"Hi");
		Query query = entityManager.createQuery(s1);
		query.setParameter(1, sellerEmailId);
		List<SellerDealsForTodayEntity> lst = query.getResultList();
		List<SellerDealsForToday> l=new ArrayList<>();
			
			for(SellerDealsForTodayEntity sdfte:lst)
			{
				SellerDealsForToday s= new SellerDealsForToday();
				s.setDealDiscount(sdfte.getDealDiscount());
				s.setDealId(sdfte.getDealId());
				s.setDealStart(sdfte.getDealStart());
				s.setDealEnd(sdfte.getDealEnd());
				s.setSellerEmailId(sdfte.getSellerEmailId());
//				System.out.println(sdfte.getSellerEmailId()+"Hello"+sdfte.getDealDiscount());
				
				Product p= new Product();
				p.setBrand(sdfte.getProductEntity().getBrand());
				p.setCategory(sdfte.getProductEntity().getCategory());
				p.setDescription(sdfte.getProductEntity().getDescription());
				p.setName(sdfte.getProductEntity().getName());
				p.setQuantity(sdfte.getProductEntity().getQuantity());
				p.setPrice(sdfte.getProductEntity().getPrice());
				p.setProductId(sdfte.getProductEntity().getProductId());
				p.setDiscount(sdfte.getProductEntity().getDiscount());
				p.setSellerEmailId(sdfte.getProductEntity().getSellerEmailId());
				
				s.setProduct(p);
				l.add(s);
			}
		
		return l;
	}
	
	@Override
	public Integer addNewDeal(SellerDealsForToday deal)
	{
//		System.out.println(deal.getDealEnd());
		SellerDealsForTodayEntity sdfte= new SellerDealsForTodayEntity();
		sdfte.setDealDiscount(deal.getDealDiscount());
		sdfte.setDealStart(deal.getDealStart());
		sdfte.setDealEnd(deal.getDealEnd());
//		System.out.println(deal.getDealEnd()+""+deal.getDealStart()+""+sdfte.getDealEnd());
		sdfte.setSellerEmailId(deal.getSellerEmailId()); 
		
		
		ProductEntity pe=new ProductEntity();
		pe.setBrand(deal.getProduct().getBrand());
		pe.setCategory(deal.getProduct().getCategory());
		pe.setDescription(deal.getProduct().getDescription());
		pe.setDiscount(deal.getProduct().getDiscount());
		pe.setName(deal.getProduct().getName());
		pe.setPrice(deal.getProduct().getPrice());
		pe.setQuantity(deal.getProduct().getQuantity());
		pe.setProductId(deal.getProduct().getProductId());
		pe.setSellerEmailId(deal.getProduct().getSellerEmailId());
		
		sdfte.setProductEntity(pe);
//		System.out.print("Before adding:"+sdfte.getDealDiscount()+""+sdfte.getDealEnd()+""+sdfte.getDealStart()+""+sdfte.getProductEntity().getProductId()+""+sdfte.getSellerEmailId());
		entityManager.persist(sdfte);
//		System.out.print("After adding:"+sdfte);
		return sdfte.getDealId();
	}
	
	@Override
	public Integer removeProductsFromDeals(Integer dealId){
		
		SellerDealsForTodayEntity sellerdealsForTodayEntity=entityManager.find(SellerDealsForTodayEntity.class,dealId);
        Integer result;
        if(sellerdealsForTodayEntity!= null){
        	sellerdealsForTodayEntity.setProductEntity(null);
        	sellerdealsForTodayEntity.setSellerEmailId(null);
        	result=sellerdealsForTodayEntity.getDealId();
        	entityManager.remove(sellerdealsForTodayEntity); 
        	result=-1;
        	
        }
        else {
        	result=0;
        }
        return result;
	}

}

