package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtspringproject.JtSpringProject.dao.categoryDao;
import com.jtspringproject.JtSpringProject.models.Category;

import net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition;
import org.springframework.transaction.annotation.Transactional;

@Service
public class categoryService {
	@Autowired
	private categoryDao categoryDao;

	public Category addCategory(String name) {
		try {
			return this.categoryDao.addCategory(name);
		} catch (Exception e) {
			throw new RuntimeException("Failed to add category", e); // Wrap and rethrow the exception
		}
	}


	
	public List<Category> getCategories(){
		return this.categoryDao.getCategories();
	}

	@Transactional
	public Boolean deleteCategory(int id) {
		return this.categoryDao.deleteCategory(id);
	}
	
	public Category updateCategory(int id,String name) {
		return this.categoryDao.updateCategory(id, name);
	}

	public Category getCategory(int id) {
		return this.categoryDao.getCategory(id);
	}
}
