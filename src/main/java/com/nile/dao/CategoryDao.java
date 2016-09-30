package com.nile.dao;

import com.nile.entity.Category;

import java.util.List;

public interface CategoryDao {
    public Category selectCategoryById(Integer id);

    public List<Category> selectCategoryAll();

    public void insertCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategory(Integer id);
}
