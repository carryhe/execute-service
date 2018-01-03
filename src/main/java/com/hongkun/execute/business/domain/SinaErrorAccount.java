package com.hongkun.execute.business.domain;

import java.util.Date;

/**
 * @author HeXG
 * @since 2018/1/3
 */
public class SinaErrorAccount {
   /*
            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'sina_account的主键',
            `sina_account` varchar(255) NOT NULL COMMENT '账号',
            `sina_pass` varchar(255) NOT NULL COMMENT '账户密码',
            `sina_uid` varchar(255) NOT NULL COMMENT '用户id',
            `sina_token` varchar(255) NOT NULL DEFAULT '',
            `sina_token_time` datetime DEFAULT NULL COMMENT '最后 登录时间',
            `sina_error_code` varchar(255) NOT NULL DEFAULT '',
            `sina_error_time` datetime DEFAULT NULL,
            `mstsc_id` varchar(255) NOT NULL DEFAULT '' COMMENT '服务器的id,默认为空',
            `sina_end_time` datetime DEFAULT NULL,
            `sina_vps_region` varchar(255) NOT NULL DEFAULT '',
            `gz_num` int(11) NOT NULL DEFAULT '0',
            `zan_num` int(11) NOT NULL DEFAULT '0',
            `forward_num` int(11) NOT NULL DEFAULT '0',
     */
   //主键id
   private Integer id;
    //新浪账号
    private String sinaAccount;
    //账号密码
    private String sinaPass;
    //用户id
    private String sinaUid;
    //新浪token值
    private String sinaToken;
    //最后登录时间
    private Date sinaTokenTime;
    //错误的code
    private String sinaErrorCode;
    //错误时间
    private Date sinaErrorTime;
    //服务器的id
    private String mstscId;
    //
    private Date sinaEndTime;
    //地址
    private String sinaVpsRegion;
    //
    private Integer gzNum;
    //
    private Integer zanNum;

    private int forwardNum;

    public int getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(int forwardNum) {
        this.forwardNum = forwardNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSinaAccount() {
        return sinaAccount;
    }

    public void setSinaAccount(String sinaAccount) {
        this.sinaAccount = sinaAccount;
    }

    public String getSinaPass() {
        return sinaPass;
    }

    public void setSinaPass(String sinaPass) {
        this.sinaPass = sinaPass;
    }

    public String getSinaUid() {
        return sinaUid;
    }

    public void setSinaUid(String sinaUid) {
        this.sinaUid = sinaUid;
    }

    public String getSinaToken() {
        return sinaToken;
    }

    public void setSinaToken(String sinaToken) {
        this.sinaToken = sinaToken;
    }

    public Date getSinaTokenTime() {
        return sinaTokenTime;
    }

    public void setSinaTokenTime(Date sinaTokenTime) {
        this.sinaTokenTime = sinaTokenTime;
    }

    public String getSinaErrorCode() {
        return sinaErrorCode;
    }

    public void setSinaErrorCode(String sinaErrorCode) {
        this.sinaErrorCode = sinaErrorCode;
    }

    public Date getSinaErrorTime() {
        return sinaErrorTime;
    }

    public void setSinaErrorTime(Date sinaErrorTime) {
        this.sinaErrorTime = sinaErrorTime;
    }

    public String getMstscId() {
        return mstscId;
    }

    public void setMstscId(String mstscId) {
        this.mstscId = mstscId;
    }

    public Date getSinaEndTime() {
        return sinaEndTime;
    }

    public void setSinaEndTime(Date sinaEndTime) {
        this.sinaEndTime = sinaEndTime;
    }

    public String getSinaVpsRegion() {
        return sinaVpsRegion;
    }

    public void setSinaVpsRegion(String sinaVpsRegion) {
        this.sinaVpsRegion = sinaVpsRegion;
    }

    public Integer getGzNum() {
        return gzNum;
    }

    public void setGzNum(Integer gzNum) {
        this.gzNum = gzNum;
    }

    public Integer getZanNum() {
        return zanNum;
    }

    public void setZanNum(Integer zanNum) {
        this.zanNum = zanNum;
    }


}
