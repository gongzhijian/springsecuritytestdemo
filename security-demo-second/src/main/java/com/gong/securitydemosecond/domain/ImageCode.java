package com.gong.securitydemosecond.domain;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author GEEX616
 * @create 2019-09-11 12:51
 * @desc
 **/
@Data
public class ImageCode {
    /**图片*/
    private BufferedImage image;

    /**生成的随机码*/
    private String code;

    /**本地当前时间*/
    private LocalDateTime expireTime;

    /**
     * 构造-----expireIn 超时时间（单位秒）
     * @param image
     * @param code
     * @param expireIn
     */
    public ImageCode(BufferedImage image, String code, int expireIn){
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    /**
     * 判断当前时间是否已经超时
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

}
