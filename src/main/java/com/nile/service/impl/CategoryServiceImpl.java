package com.nile.service.impl;

import com.nile.dao.CategoryDao;
import com.nile.entity.Category;
import com.nile.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category selectCategoryById(int id) {
        return categoryDao.selectCategoryById(id);
    }

    @Override
    public void insertCategory(Category category) {
        categoryDao.insertCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryDao.deleteCategory(id);
    }

    @Override
    public List<Category> selectAll() {
        return null;
    }
}
