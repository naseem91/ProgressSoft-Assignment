package com.progresssoft.dao;

import java.util.List;

import com.progresssoft.model.ValidDeal;

public interface DealDAO extends BaseDAO {

	public void InsertDeal(ValidDeal deal);
	
	public void insertBulkIntoDeal(List<ValidDeal> bulk);
	
	public  List<ValidDeal> findAll();

	public ValidDeal findById(Integer id);
}
