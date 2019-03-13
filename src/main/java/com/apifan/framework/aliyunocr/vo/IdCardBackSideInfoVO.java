package com.apifan.framework.aliyunocr.vo;

/**
 * 身份证反面识别结果
 *
 * @author yinzl
 */
public class IdCardBackSideInfoVO {

    private String config_str;
    private String start_date;
    private String end_date;
    private String issue;
    private boolean success;

    public String getConfig_str() {
        return config_str;
    }

    public void setConfig_str(String config_str) {
        this.config_str = config_str;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
