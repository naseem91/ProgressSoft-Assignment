package com.progresssoft.dao;

import java.util.List;


public interface BaseDAO {

	public <T> T findById(Integer id);

	public <T> List<T> findAll();

	public boolean deleteById(Integer Id);
}
