package com.javafan.tmall.service.impl;

import com.javafan.tmall.mapper.CategoryMapper;
import com.javafan.tmall.pojo.Category;
import com.javafan.tmall.pojo.CategoryExample;
import com.javafan.tmall.service.CategoryService;
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
    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void add(Category category) {
        categoryMapper.insertSelective(category);

    }

    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}
