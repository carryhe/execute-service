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

    private int forwardNum;
/* `forward_error_code` varchar(222) NOT NULL DEFAULT '',
  `forward_error_time` datetime DEFAULT NULL,
  `fans_error_code` varchar(255) NOT NULL DEFAULT '',
  `fans_error_time` datetime DEFAULT NULL,
  `like_error_code` varchar(255) NOT NULL DEFAULT '',
  `like_error_time` datetime DEFAULT NULL,
  */
    private String forwardErrorCode;
    private Date forwardErrorTime;
    private String fansErrorCode;
    private Date fansErrorTime;
    private String likeErrorCode;
    private Date likeErrorTime;

    public String getForwardErrorCode() {
        return forwardErrorCode;
    }

    public void setForwardErrorCode(String forwardErrorCode) {
        this.forwardErrorCode = forwardErrorCode;
    }

    public Date getForwardErrorTime() {
        return forwardErrorTime;
    }

    public void setForwardErrorTime(Date forwardErrorTime) {
        this.forwardErrorTime = forwardErrorTime;
    }

    public String getFansErrorCode() {
        return fansErrorCode;
    }

    public void setFansErrorCode(String fansErrorCode) {
        this.fansErrorCode = fansErrorCode;
    }

    public Date getFansErrorTime() {
        return fansErrorTime;
    }

    public void setFansErrorTime(Date fansErrorTime) {
        this.fansErrorTime = fansErrorTime;
    }

    public String getLikeErrorCode() {
        return likeErrorCode;
    }

    public void setLikeErrorCode(String likeErrorCode) {
        this.likeErrorCode = likeErrorCode;
    }

    public Date getLikeErrorTime() {
        return likeErrorTime;
    }

    public void setLikeErrorTime(Date likeErrorTime) {
        this.likeErrorTime = likeErrorTime;
    }

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
