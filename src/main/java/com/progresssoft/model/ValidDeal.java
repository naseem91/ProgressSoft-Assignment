package com.progresssoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 
 * @author Naseem Adel 
 *
 */

@Entity
@Table(name="validdeal")
public class ValidDeal {

	@Id
	@Column(name = "deal_id")
	private int Id;
	
	private String fromCurrency;
	private String toCurrency;
	private Date dealDate;
	private double dealAmount;
	
	//private Customer customer;
	
	public ValidDeal() {
		
		
	}
	
	public ValidDeal(int id) {
		this.Id = id;
	}

	/**
	 * 
	 * @param id
	 * @param fromCurrency
	 * @param toCurrency
	 * @param dealDate
	 * @param dealAmount
	 */
	public ValidDeal(Integer id, String fromCurrency, String toCurrency, Date dealDate, double dealAmount) {
		super();
		Id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.dealDate = dealDate;
		this.dealAmount = dealAmount;
	}

	/**
	 * 
	 * @return Deal ID
 	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * 
	 * @param id for Deal 
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * 
	 * @return Ordering currency
	 */
	public String getFromCurrency() {
		return fromCurrency;
	}

	/***
	 * 
	 * @param fromCurrency ,Ordering currency
	 */
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	/**
	 * 
	 * @return to currency
	 */
	public String getToCurrency() {
		return toCurrency;
	}

	/**
	 * 
	 * @param toCurrency
	 */
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	/**
	 * 
	 * @return Deal timestamp
	 */
	public Date getDealDate() {
		return dealDate;
	}

	/**
	 * 
	 * @param dealDate ,Deal timestamp
	 */
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	/**
	 * 
	 * @return Deal amount
 	 */
	public double getDealAmount() {
		return dealAmount;
	}

	/**
	 * 
	 * @param dealAmount
	 */
	public void setDealAmount(double dealAmount) {
		this.dealAmount = dealAmount;
	}
	
}
