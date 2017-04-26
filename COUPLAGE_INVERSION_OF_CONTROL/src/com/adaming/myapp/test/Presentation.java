package com.adaming.myapp.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.adaming.myapp.dao.DaoImpl;
import com.adaming.myapp.dao.IDao;
import com.adaming.myapp.service.IService;
import com.adaming.myapp.service.ServiceImpl;

public class Presentation {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/*IDao dao =new DaoImpl();  //static
		ServiceImpl service = new ServiceImpl();
		service.setDao(dao);
		System.out.println(service.getValue());
		*/
		
		try {
			Scanner sc = new Scanner(new File("config"));
			
			String daoClassName = sc.next();
			String serviceClassName = sc.next();
			Class daoImpl = Class.forName(daoClassName);
			IDao dao = (IDao) daoImpl.newInstance();
			
			Class serviceImpl = Class.forName(serviceClassName);
			ServiceImpl service = (ServiceImpl)serviceImpl.newInstance();
			
			Method m = serviceImpl.getMethod("setDao", IDao.class);
			m.invoke(service, dao);
			System.out.println(service.getValue());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {   //reflexion
			Class daoImpl = Class.forName("com.adaming.myapp.dao.DaoImpl");
			DaoImpl dao = (DaoImpl) daoImpl.newInstance();
			System.out.println(dao.getValue());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*Class s = String.class;
		Method [] m = s.getMethods();
		
		for (Method x : m){
			System.out.println(x.getName());
		}
		
		Class [] c = s.getInterfaces();
		for (Class y : c){
			System.out.println(y.getName());
		}*/
		
		
	}
	
	

}
