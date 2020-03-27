package com.javafan.tmall.service;

import com.javafan.tmall.pojo.Category;

import java.util.List;

/**
 * @author JavaFan
 * @version 1.0
 * @date 2020/3/25 9:17 上午
 */
public interface CategoryService {
    /**
     * 返回分类的list
     *
     * @return
     */
    List<Category> list();


   void add(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);
}
