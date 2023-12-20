package com.pms.service;

import java.util.List;
import com.pms.dao.ProductDao;
import com.pms.entity.Products;



public class ProductService {
ProductDao pd = new ProductDao();
	
	public String storeProduct(Products product) {
		if(product.getPrice()<1000) {
			return "Price must be > 1000";
		}else if(pd.storeProduct(product)>0) {
			return "Product details stored successfully";
		}else {
			return "Product didn't store";
		}
	}
	
	public List<Products> findAllProduct() {
		// if we want we can apply some condition. 
		return pd.findAllProduct();
	}
	
	public String deleteProduct(int pid) {
		if(pd.deleteProduct(pid)>0) {
			return "Product deleted successfully";
		}else {
			return "Product not present";
		}
	}

}
