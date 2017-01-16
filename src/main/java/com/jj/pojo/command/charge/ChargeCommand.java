package com.jj.pojo.command.charge;

import com.jj.pojo.qo.front.BaseFrontQO;

/**
 * 话费兑换COMMAND
 * Created by jj on 2016/9/23.
 */
public class ChargeCommand extends BaseFrontQO{
    /**
     * 充值金额
     */
    private Integer chargeValue;

    /**
     * 充值的手机号
     */
    private String phoneNum;

    public Integer getChargeValue() {
        return chargeValue;
    }

    public void setChargeValue(Integer chargeValue) {
        this.chargeValue = chargeValue;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
