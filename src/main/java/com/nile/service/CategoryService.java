package com.nile.service;

import com.nile.entity.Category;

import java.util.List;

public interface CategoryService {

    public Category selectCategoryById(int id);

    public void insertCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategoryById(Integer id);

    public List<Category> selectAll();
}
