package com.javafan.tmall.service.impl;

import com.javafan.tmall.mapper.CategoryMapper;
import com.javafan.tmall.pojo.Category;
import com.javafan.tmall.service.CategoryService;
import com.javafan.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JavaFan
 * @version 1.0
 * @date 2020/3/25 9:18 上午
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;




    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }

    @Override
    public int total() {
     return    categoryMapper.total();
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);

    }

    @Override
    public void delete(int id) {
        categoryMapper.delete(id);

    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);

    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);

    }


}
