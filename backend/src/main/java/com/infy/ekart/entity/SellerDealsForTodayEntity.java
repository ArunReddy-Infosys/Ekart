package com.infy.ekart.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "EK_DEALS_FOR_TODAY")
public class SellerDealsForTodayEntity {
	@Id
	@Column(name="DEAL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer dealId;
	
	@OneToOne
	@JoinColumn(name="PRODUCT_ID",unique=true)
	private ProductEntity productEntity;
	
	@Column(name="DEAL_DISCOUNT")
	private Double dealDiscount;
	
	@Column(name="DEAL_STARTS_AT")
	private LocalDateTime dealStart;
	
	@Column(name="DEAL_ENDS_AT")
	private LocalDateTime dealEnd;
	
	@Column(name="SELLER_EMAIL_ID")
	private String sellerEmailId;
	
	public Integer getDealId() {
		return dealId;
	}
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
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
	
	
	@Override
	public String toString() {
		return "SellerDealsForTodayEntity [dealId=" + dealId + ", productEntity=" + productEntity + ", dealDiscount="
				+ dealDiscount + ", dealStart=" + dealStart + ", dealEnd=" + dealEnd + ", sellerEmailId="
				+ sellerEmailId + "]";
	}
	
	

}
