# 阿里云图像识别工具封装starter
## 概述
包含阿里云图像识别客户端一些常用的配置和逻辑。建议需要用到阿里云图像识别的工程都引入。

## 引入
```
<dependency>
    <groupId>com.apifan.framework</groupId>
    <artifactId>aliyunocr-spring-boot-starter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## 配置说明
```
aliyunocr:
  app-code: 123456789
```

## 使用范例
```
@Autowired
private AliyunOcrHelper aliyunOcrHelper;
    
//...


public void recognize(){
    String imageStr1, imageStr2, imageStr3;
    //识别身份证正面图
    aliyunOcrHelper.recognizeIdCardFaceSide(imageStr1);
    
    //识别身份证反面图
    aliyunOcrHelper.recognizeIdCardBackSide(imageStr2);
    
    //识别营业执照正面图
    aliyunOcrHelper.recognizeBusinessLicense(imageStr3);
    //后续处理逻辑... ...
    
}

```

## 目前支持范围
- 身份证图片：https://market.aliyun.com/products/57124001/cmapi010401.html#sku=yuncode440100000
- 营业执照图片：https://market.aliyun.com/products/57124001/cmapi013592.html?#sku=yuncode759200000