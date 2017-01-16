package com.jj.pojo.qo.front;

@SuppressWarnings("serial")
public class ShowCommoditiesQO extends BaseFrontQO {
    /**
     * userId加密后的串
     */
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
