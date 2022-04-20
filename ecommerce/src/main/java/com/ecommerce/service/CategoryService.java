package com.ecommerce.service;

import com.ecommerce.dao.Category;
import com.ecommerce.repository.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public void createCategory(Category category) {
        categoryRepo.save(category);
    }

    public List<Category> listCategory() {
        return categoryRepo.findAll();
    }

    public void editCategory(int categoryId, Category updateCategory) {
        Category category = categoryRepo.getById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        categoryRepo.save(category);
    }

    public boolean findById(int categoryId) {
        return categoryRepo.findById(categoryId).isPresent();
    }
}
