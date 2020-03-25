package com.javafan.tmall.mapper;

import com.javafan.tmall.pojo.Category;
import com.javafan.tmall.util.Page;

import java.util.List;

/**
 * @author JavaFan
 * @version 1.0
 * @date 2020/3/25 9:12 上午
 */

public interface CategoryMapper {
    /**
     * 根据分页信息返回分类的数据
     * @param page 分页信息
     * @return
     */
    public List<Category> list(Page page);

    /**
     * 返回分类信息的总记录数
     * @return 总记录数
     */
    public int total();

    /**
     * 添加分类
     * @param category 分类信息
     */
    void add(Category category);

    /**
     * 删除分类信息
     * @param id 所在分类项的ID值 对应的是数据库中category的ID
     */
    void delete(int id);

    /**
     * 获取对应id的category信息
     * @param id category的id
     * @return
     */
    Category get(int id);

    /**
     * 更新分类信息
     * @param category
     */
    void update(Category category);

}
