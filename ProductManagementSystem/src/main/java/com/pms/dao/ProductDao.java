package com.pms.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.pms.entity.Products;
import com.pms.resource.SessionFactoryResource;

public class ProductDao {
	public int storeProduct(Products product) {
		try {
			SessionFactory sf = SessionFactoryResource.getSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
				session.save(product);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<Products> findAllProduct() {
		SessionFactory sf = SessionFactoryResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Product");  
		List<Products> listOfProduct = tq.getResultList();
		return listOfProduct;
	}
	
	public int deleteProduct(int pid) {
		
			SessionFactory sf = SessionFactoryResource.getSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			Products p = session.find(Products.class, pid);

			if(p==null) {
				return 0;
			}else {
				tran.begin();
					session.delete(p);
				tran.commit();
				return 1;
			}
	}

}
