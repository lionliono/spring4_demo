package com.jj.pojo.command.charge;

/**
 * Created by jj on 2016/9/26.
 */
public class TrafficCommand {
    /**
     * 手机号*
     */
    private String phone;
    /**
     * 金额(1,5,10)*
     */
    private Integer gold;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
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
