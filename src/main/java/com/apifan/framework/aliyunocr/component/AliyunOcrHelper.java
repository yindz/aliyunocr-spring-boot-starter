package com.apifan.framework.aliyunocr.component;

import com.apifan.biz.common.constant.CommonConstant;
import com.apifan.biz.common.util.JsonUtils;
import com.apifan.biz.common.util.StringUtils;
import com.apifan.biz.common.util.http.HttpResponse;
import com.apifan.biz.common.util.http.HttpUtils;
import com.apifan.framework.aliyunocr.config.AliyunOcrProperties;
import com.apifan.framework.aliyunocr.vo.BusinessLicenseInfoVO;
import com.apifan.framework.aliyunocr.vo.IdCardBackSideInfoVO;
import com.apifan.framework.aliyunocr.vo.IdCardFaceSideInfoVO;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * 阿里云OCR辅助工具
 *
 * @author yinzl
 */
public class AliyunOcrHelper {
    private static final Logger logger = LoggerFactory.getLogger(AliyunOcrHelper.class);

    /**
     * 身份证识别接口URL
     */
    private static final String ID_CARD_URL = "http://dm-51.data.aliyun.com/rest/160601/ocr/ocr_idcard.json";

    /**
     * 营业执照识别接口URL
     */
    private static final String BUSINESS_LICENSE_URL = "http://dm-58.data.aliyun.com/rest/160601/ocr/ocr_business_license.json";

    private String authorization;

    private final AliyunOcrProperties aliyunOcrProperties;

    private boolean initSuccess;

    public AliyunOcrHelper(AliyunOcrProperties aliyunOcrProperties) {
        this.aliyunOcrProperties = aliyunOcrProperties;
    }

    /**
     * 初始化
     */
    public void init() {
        if (initSuccess) {
            return;
        }
        Preconditions.checkArgument(StringUtils.isNotEmpty(aliyunOcrProperties.getAppCode()), "appCode不能为空");
        this.authorization = "APPCODE " + aliyunOcrProperties.getAppCode();
        logger.info("阿里云OCR辅助工具初始化成功");
        initSuccess = true;
    }

    /**
     * 识别身份证正面图像
     *
     * @param imageStr 待识别的图片（base64编码后）
     * @return 识别结果
     */
    public IdCardFaceSideInfoVO recognizeIdCardFaceSide(String imageStr) {
        String json = getResponseJson(ID_CARD_URL, buildIdCardRequestJson(imageStr, "face"));
        if (StringUtils.isEmpty(json)) {
            logger.error("身份证正面图像识别失败");
            return null;
        }
        logger.info("身份证正面识别结果: {}", json);
        return JsonUtils.readAsObject(json, IdCardFaceSideInfoVO.class);
    }

    /**
     * 识别身份证反面图像
     *
     * @param imageStr 待识别的图片（base64编码后）
     * @return 识别结果
     */
    public IdCardBackSideInfoVO recognizeIdCardBackSide(String imageStr) {
        String json = getResponseJson(ID_CARD_URL, buildIdCardRequestJson(imageStr, "back"));
        if (StringUtils.isEmpty(json)) {
            logger.error("身份证反面图像识别失败");
            return null;
        }
        logger.info("身份证反面识别结果: {}", json);
        return JsonUtils.readAsObject(json, IdCardBackSideInfoVO.class);
    }

    /**
     * 识别营业执照图像
     *
     * @param imageStr 待识别的图片（base64编码后）
     * @return 识别结果
     */
    public BusinessLicenseInfoVO recognizeBusinessLicense(String imageStr) {
        if (StringUtils.isEmpty(imageStr)) {
            return null;
        }

        String json = getResponseJson(BUSINESS_LICENSE_URL, buildBusinessLicenseRequestJson(imageStr));
        if (StringUtils.isEmpty(json)) {
            logger.error("营业执照图像识别失败");
            return null;
        }
        logger.info("营业执照识别结果: {}", json);
        return JsonUtils.readAsObject(json, BusinessLicenseInfoVO.class);
    }

    /**
     * 构建请求参数JSON
     *
     * @param imageStr 待识别的图片（base64编码后）
     * @param side     身份证正反面类型:face/back
     * @return JSON
     */
    private String buildIdCardRequestJson(String imageStr, String side) {
        Map<String, String> paramsMap = Maps.newHashMap();
        paramsMap.put("image", imageStr);
        paramsMap.put("configure", "{\"side\":\"" + side + "\"}");
        return JsonUtils.toJson(paramsMap);
    }

    /**
     * 构建请求参数JSON
     *
     * @param imageStr 待识别的图片（base64编码后）
     * @return JSON
     */
    private String buildBusinessLicenseRequestJson(String imageStr) {
        Map<String, String> paramsMap = Maps.newHashMap();
        paramsMap.put("image", imageStr);
        return JsonUtils.toJson(paramsMap);
    }

    /**
     * 获取响应数据
     *
     * @param url
     * @param requestJson
     * @return
     */
    private String getResponseJson(String url, String requestJson) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(url), "URL为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(requestJson), "requestJson为空");
        Map<String, String> headersMap = Maps.newHashMap();
        headersMap.put("Authorization", authorization);
        try {
            HttpResponse response = HttpUtils.postJson(url, headersMap, requestJson);
            if (response == null || response.getCode() != CommonConstant.HTTP_OK) {
                logger.error("图像识别失败: {}", response);
                return null;
            }
            return response.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
