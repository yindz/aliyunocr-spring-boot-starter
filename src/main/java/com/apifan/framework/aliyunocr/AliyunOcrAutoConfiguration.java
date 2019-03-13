package com.apifan.framework.aliyunocr;

import com.apifan.framework.aliyunocr.component.AliyunOcrHelper;
import com.apifan.framework.aliyunocr.config.AliyunOcrProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @author yinzl
 */
@Configuration
@ConditionalOnProperty(prefix = "aliyunocr", name = "app-code")
@EnableConfigurationProperties(AliyunOcrProperties.class)
@ComponentScan(basePackages = "com.apifan.framework.aliyunocr")
public class AliyunOcrAutoConfiguration {

    private final AliyunOcrProperties aliyunOcrProperties;

    public AliyunOcrAutoConfiguration(final AliyunOcrProperties aliyunOcrProperties) {
        this.aliyunOcrProperties = aliyunOcrProperties;
    }

    /**
     * 阿里云图像识别辅助工具
     *
     * @return
     */
    @Bean
    public AliyunOcrHelper aliyunOcrHelper() {
        final AliyunOcrHelper helper = new AliyunOcrHelper(aliyunOcrProperties);
        helper.init();
        return helper;
    }
}
