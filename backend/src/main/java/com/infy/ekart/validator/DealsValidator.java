package com.infy.ekart.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.infy.ekart.model.SellerDealsForToday;


public class DealsValidator {
	public static void validateDeals(SellerDealsForToday todayDeal) throws Exception
	{
		if(!validateDate(todayDeal.getDealStart(), todayDeal.getDealEnd()))
		{
			throw new Exception("DealsValidator.INVALID_DATE");
		}
		if(!validateRange(todayDeal.getDealStart()))
		{
			throw new Exception("DealsValidator.INVALID_DATE_RANGE");
		}
		if(!validateRange(todayDeal.getDealEnd()))
		{
			throw new Exception("DealsValidator.INVALID_DATE_RANGE");
		}
		if(!validateTime(todayDeal.getDealStart(), todayDeal.getDealEnd()))
		{
			throw new Exception("DealsValidator.INVALID_TIME");
		}
		if(!validateDiscount(todayDeal.getDealDiscount()))
		{
			throw new Exception("DealsValidator.INVALID_DISCOUNT");
		}
	}
	public static boolean validateDate(LocalDateTime startDate, LocalDateTime endDate)
	{
		LocalDate start= startDate.toLocalDate();
		LocalDate end = endDate.toLocalDate();
		if(start.isEqual(end))
		{
			return true;
		}
		return false;
	}
	public static boolean validateRange(LocalDateTime date)
	{
		LocalDate startDate=date.toLocalDate();
		LocalDate today=LocalDateTime.now().toLocalDate();
		LocalDate lastDate=today.plusMonths(1);
		if(startDate.isAfter(today)&& startDate.isBefore(lastDate))
		{
			return true;
		}
		return false;
	}
	public static boolean validateTime(LocalDateTime startTime, LocalDateTime endTime)
	{
		if(startTime.isBefore(endTime))
		{
			return true;
		}
		return false;
	}
	public static Boolean validateDiscount(Double discount)
	{
		return discount>0 && discount<=100;
	}
}
