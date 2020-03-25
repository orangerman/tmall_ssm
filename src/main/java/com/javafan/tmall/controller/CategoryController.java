package com.javafan.tmall.controller;

import com.javafan.tmall.pojo.Category;
import com.javafan.tmall.service.CategoryService;
import com.javafan.tmall.util.ImageUtil;
import com.javafan.tmall.util.Page;
import com.javafan.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.imageio.ImageIO;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author JavaFan
 * @version 1.0
 * @date 2020/3/25 9:42 上午
 */
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @RequestMapping("admin_category_update")
    public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.update(c);
        MultipartFile image = uploadedImageFile.getImage();
        if(null!=image &&!image.isEmpty()){
            File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_category_list";
    }


    /**
     * 编辑对应的信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("admin_category_edit")
    public String edit(int id, Model model) {
        Category category = categoryService.get(id);
        model.addAttribute("c", category);

        return "admin/editCategory";
    }



    /**
     * 删除指定位置的分类信息
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("admin_category_delete")
    public String delete(int id, HttpSession session) {
        categoryService.delete(id);

        //删除对应的图片
        File imageFolder = new File(session.getServletContext().getRealPath("/img/category"));
        File file = new File(imageFolder, id + ".jpg");
        file.delete();

        //返回分页首页
        return "redirect:/admin_category_list";

    }


    /**
     * 增加新的分类信息 添加图片
     *
     * @param c                 从前端传递过来的 category信息 包含name和id
     * @param session           session里面含有Img信息
     * @param uploadedImageFile 转换照片格式 同意jpg
     * @return
     * @throws IOException
     */
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.add(c);
        File imageFolder = new File(session.getServletContext().getRealPath("/img/category"));
        File file = new File(imageFolder, c.getId() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        ;
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);


        return "redirect:/admin_category_list";
    }


    /**
     * 来到list页面 展示分页信息
     *
     * @param model 存放来list信息
     * @param page  分页信息
     * @return
     */
    @RequestMapping("admin_category_list")
    public String list(Model model, Page page) {

        List<Category> cs = categoryService.list(page);
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
}
