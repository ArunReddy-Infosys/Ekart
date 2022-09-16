package com.infy.ekart.model;


import java.time.LocalDateTime;



public class SellerDealsForToday {
	private Integer dealId;
	private Product product;
	private Double dealDiscount;
	private LocalDateTime dealStart;
	private LocalDateTime dealEnd;
	private String sellerEmailId;
	private String dealMessage;
	
	public Integer getDealId() {
		return dealId;
	}
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Double getDealDiscount() {
		return dealDiscount;
	}
	public void setDealDiscount(Double dealDiscount) {
		this.dealDiscount = dealDiscount;
	}
	public LocalDateTime getDealStart() {
		return dealStart;
	}
	public void setDealStart(LocalDateTime dealStart) {
		this.dealStart = dealStart;
	}
	public LocalDateTime getDealEnd() {
		return dealEnd;
	}
	public void setDealEnd(LocalDateTime dealEnd) {
		this.dealEnd = dealEnd;
	}
	public String getSellerEmailId() {
		return sellerEmailId;
	}
	public void setSellerEmailId(String sellerEmailId) {
		this.sellerEmailId = sellerEmailId;
	}
	public String getDealMessage() {
		return dealMessage;
	}
	public void setDealMessage(String dealMessage) {
		this.dealMessage = dealMessage;
	}
	
	
	
	
	
}
