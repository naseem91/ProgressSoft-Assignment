package com.progresssoft.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.progresssoft.config.HibUtil;
import com.progresssoft.model.ValidDeal;


public class DealDAOImpl implements DealDAO{

	/**
	 * This function is responsible for adding the Correct Deals into the database 
	 */
	@Override
	public void InsertDeal(ValidDeal deal) {
		// TODO Auto-generated method stub
		Session session = HibUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(deal);
		try {
		  session.getTransaction().commit();
		  System.out.println("Deal inserted successfully !!");
		}
		catch (HibernateException hibernateEx) {
			// TODO: handle exception
			System.out.println("Could not add this Deal, it's already exist !!");
		}
		finally {
			if(session != null)
			session.close();
		}
	}

	@Override
	public void insertBulkIntoDeal(List<ValidDeal> bulk) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean deleteById(Integer Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ValidDeal> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValidDeal findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
