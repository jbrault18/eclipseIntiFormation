package com.adaming.myapp.service;

import com.adaming.myapp.dao.DaoImpl;
import com.adaming.myapp.dao.DaoImplV2;
import com.adaming.myapp.dao.IDao;

public class ServiceImpl implements IService{

	private IDao dao= null;
	
	@Override
	public double getValue() {
		double tempA = 50;
		return dao.getValue()-tempA;
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	
}
