package com.jj.pojo.command.charge;

import com.jj.pojo.command.BaseCommand;

/**
 * Created by jj on 2016/10/26.
 */
public class ApiChargeCommand extends BaseCommand{

    /**
     * 消耗积分数量
     * 和服务器进行比对用
     */
    private Integer needDoubi;

    /**
     * 充值金额
     */
    private Integer chargeValue;

    /**
     * 充值的手机号
     */
    private String phoneNum;

    /**
     * 时间戳(当前时间毫秒)*
     */
    private Long time;
    /**
     * 签名*
     * sign签名规则: MD5(手机号+金额+时间戳+私钥)
     * 私钥=34a7268ed9a74ea7a9a1e6b1e596cfba
     */
    private String sign;
    /**
     * 名称
     */
    private String subject;
    /**
     * 帐号
     */
    private String userName;
    /**
     * 帐号ID
     */
    private Integer userId;
    /**
     * 服务器ID
     */
    private Integer serverId;
    /**
     *  来源
     */
    private String fromClient;

    public Integer getNeedDoubi() {
        return needDoubi;
    }

    public void setNeedDoubi(Integer needDoubi) {
        this.needDoubi = needDoubi;
    }

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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getFromClient() {
        return fromClient;
    }

    public void setFromClient(String fromClient) {
        this.fromClient = fromClient;
    }
}
