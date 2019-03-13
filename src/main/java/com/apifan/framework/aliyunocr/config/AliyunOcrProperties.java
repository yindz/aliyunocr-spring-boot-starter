package com.apifan.framework.aliyunocr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云OCR配置
 *
 * @author yinzl
 */
@Component
@ConfigurationProperties(prefix = "aliyunocr")
public class AliyunOcrProperties {

    /**
     * appCode
     */
    private String appCode;

    /**
     * 获取 appCode
     *
     * @return appCode appCode
     */
    public String getAppCode() {
        return this.appCode;
    }

    /**
     * 设置 appCode
     *
     * @param appCode appCode
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
}
