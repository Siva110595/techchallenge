package com.example.techchallenge.dao;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Repository;

import com.example.techchallenge.model.Interest;

@Repository
public class InterestCalculationDao {
	public double getResult(Interest interest) {
		String type=interest.getAgreementtype();
		double total = 0.0;
		double RR=9.75;
		double interestValue;
		double amount=interest.getAmount();
		LocalDate localDate1 = LocalDate.parse(interest.getEnddate());
		LocalDate localDate2 = LocalDate.parse(interest.getStartdate());
		long numberOfDays = Period.between(localDate1, localDate2).getDays();
		if(type.equalsIgnoreCase("Mortgage agreements")){
			interestValue=( (RR * 2.2) + (5/100) ) /100;
			total=amount*interestValue*numberOfDays/365;
		}
		else if(type.equalsIgnoreCase("Credit facilities") || type.equalsIgnoreCase("Other credit agreements")){
			interestValue=( (RR * 2.2) + (10/100)) /100;
			total=amount*interestValue*numberOfDays/365;
		}

		else if(type.equalsIgnoreCase("Unsecured credit transactions") || type.equalsIgnoreCase("Developmental credit agreements For low income housing (unsecured)") ||
				type.equalsIgnoreCase("Developmental credit agreements For development of a small business") )	{
			interestValue=( (RR * 2.2) + (20/100)) /100;
			total=amount*interestValue*numberOfDays/365;
		}

		else if(type.equalsIgnoreCase("Short term credit transactions")) {
			interestValue=( (RR * 2.2) + (5/12)) /100;
			total=amount*interestValue*numberOfDays/365;
		}
		else if(type.equalsIgnoreCase("Incidental credit agreements")) {
			interestValue=( (RR * 2.2) + (2/12)) /100;
			total=amount*interestValue*numberOfDays/365;
		}
		return Math.abs(total);
	}




}
