package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import com.jtspringproject.JtSpringProject.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtspringproject.JtSpringProject.dao.productDao;
import com.jtspringproject.JtSpringProject.models.Product;
import org.springframework.transaction.annotation.Transactional;

@Service
public class productService {
	@Autowired
	private productDao productDao;

	public List<Product> getProducts(){
		return this.productDao.getProducts();
	}
	
	public Product addProduct(Product product) {
		return this.productDao.addProduct(product);
	}
	
	public Product getProduct(int id) {
		return this.productDao.getProduct(id);
	}
	@Transactional
	public Product updateProduct(int id, String name, Category category, int price, int weight, int quantity, String description, String productImage) {
		return this.productDao.updateProduct(id, name, category, price, weight, quantity, description, productImage);
	}


	public boolean deleteProduct(int id) {
		return this.productDao.deletProduct(id);
	}


}
