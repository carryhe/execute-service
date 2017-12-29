package com.hongkun.execute.business.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HeXG
 * @since 2017/12/26
 */
public class SinaAccount implements Serializable {

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
    //是否有用户在使用此账号
    private Integer sign;

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
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

    @Override
    public String toString() {
        return "SinaAccount{" +
                "id=" + id +
                ", sinaAccount='" + sinaAccount + '\'' +
                ", sinaPass='" + sinaPass + '\'' +
                ", sinaUid='" + sinaUid + '\'' +
                ", sinaToken='" + sinaToken + '\'' +
                ", sianTokenTime=" + sinaTokenTime +
                ", sinaErrorCode='" + sinaErrorCode + '\'' +
                ", sinaErrorTime=" + sinaErrorTime +
                ", mstscId='" + mstscId + '\'' +
                ", sinaEndTime=" + sinaEndTime +
                ", sinaVpsRegion='" + sinaVpsRegion + '\'' +
                ", gzNum=" + gzNum +
                ", zanNum=" + zanNum +
                '}';
    }
}
