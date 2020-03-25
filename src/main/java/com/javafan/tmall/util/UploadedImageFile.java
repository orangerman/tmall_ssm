package com.javafan.tmall.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author JavaFan
 * @version 1.0
 * @date 2020/3/25 2:06 下午
 */
public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
