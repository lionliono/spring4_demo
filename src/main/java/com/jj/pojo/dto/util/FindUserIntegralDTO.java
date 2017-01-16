package com.jj.pojo.dto.util;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jj on 2016/8/9.
 */
public class FindUserIntegralDTO implements Serializable {
    private String message;
    private String statusCode;
    private List<UserIntegral> info;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<UserIntegral> getInfo() {
        return info;
    }

    public void setInfo(List<UserIntegral> info) {
        this.info = info;
    }
}
