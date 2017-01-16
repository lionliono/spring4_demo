package com.jj.pojo.dto.traffic;

/**
 * Created by jj on 2016/9/26.
 */
public class TrafficDTO {
    /**
     * 200=成功,300=失败,301=非白名单,302=参数不完整,303=金额无效,304=签名无效，305=重复请求,306=易赏处理错误
     */
    private String statusCode;
    /**
     * 提示信息
     */
    private String message;
    /**
     * statusCode=306才有该值返回  易赏错误编号
     */
    private String result;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
