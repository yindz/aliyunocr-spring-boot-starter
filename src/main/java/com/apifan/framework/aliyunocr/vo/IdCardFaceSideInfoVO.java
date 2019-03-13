package com.apifan.framework.aliyunocr.vo;

import java.util.List;

/**
 * 身份证正面识别结果
 *
 * @author yinzl
 */
public class IdCardFaceSideInfoVO {

    private String address;
    private String config_str;
    private FaceRectBean face_rect;
    private String name;
    private String nationality;
    private String num;
    private String sex;
    private String birth;
    private boolean success;
    private List<FaceRectVerticesBean> face_rect_vertices;
    private String request_id;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConfig_str() {
        return config_str;
    }

    public void setConfig_str(String config_str) {
        this.config_str = config_str;
    }

    public FaceRectBean getFace_rect() {
        return face_rect;
    }

    public void setFace_rect(FaceRectBean face_rect) {
        this.face_rect = face_rect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<FaceRectVerticesBean> getFace_rect_vertices() {
        return face_rect_vertices;
    }

    public void setFace_rect_vertices(List<FaceRectVerticesBean> face_rect_vertices) {
        this.face_rect_vertices = face_rect_vertices;
    }

    /**
     * 获取
     *
     * @return request_id
     */
    public String getRequest_id() {
        return this.request_id;
    }

    /**
     * 设置
     *
     * @param request_id
     */
    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public static class FaceRectBean {
        private int angle;
        private CenterBean center;
        private SizeBean size;

        public int getAngle() {
            return angle;
        }

        public void setAngle(int angle) {
            this.angle = angle;
        }

        public CenterBean getCenter() {
            return center;
        }

        public void setCenter(CenterBean center) {
            this.center = center;
        }

        public SizeBean getSize() {
            return size;
        }

        public void setSize(SizeBean size) {
            this.size = size;
        }

        public static class CenterBean {
            /**
             * x : 952
             * y : 325.5
             */

            private int x;
            private double y;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }
        }

        public static class SizeBean {
            /**
             * height : 181.99
             * width : 164.99
             */

            private double height;
            private double width;

            public double getHeight() {
                return height;
            }

            public void setHeight(double height) {
                this.height = height;
            }

            public double getWidth() {
                return width;
            }

            public void setWidth(double width) {
                this.width = width;
            }
        }
    }

    public static class FaceRectVerticesBean {
        /**
         * x : 1024.6600341796875
         * y : 336.629638671875
         */

        private double x;
        private double y;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }
}
