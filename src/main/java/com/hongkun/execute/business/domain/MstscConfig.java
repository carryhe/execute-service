package com.hongkun.execute.business.domain;

import java.util.Date;

/**
 * @author HeXG
 * @since 2018/1/8
 */
public class MstscConfig {
    /*
    *`id` int(255) NOT NULL AUTO_INCREMENT,
      `mstsc_adsl_title` varchar(255) NOT NULL,
      `mstsc_adsl_name` varchar(255) NOT NULL,
      `mstsc_adsl_pass` varchar(255) NOT NULL,
      `mstsc_end_time` datetime NOT NULL,
      `plan_name` varchar(255) DEFAULT NULL,
      `vps_prot` varchar(255) DEFAULT NULL,
      `vps_over_time` datetime DEFAULT NULL,
      `vps_region` varchar(255) DEFAULT NULL,
      `version` varchar(255) DEFAULT NULL,
      `beizhu` varchar(255) DEFAULT NULL,
      `sina_run_time` int(11) DEFAULT NULL,
      `is_upload_account` varchar(255) DEFAULT NULL,
    *
     */
    private Integer id;
    private String mstscAdslTitle;
    private String mstscAdslName;
    private String mstscAdslPass;
    private Date mstscEndTime;
    private String planName;
    private String vpsProt;
    private Date vpsOverTime;
    private String vpsRegion;
    private String version;
    private String beizhu;
    private Integer sinaRunTime;
    private String isUploadAccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMstscAdslTitle() {
        return mstscAdslTitle;
    }

    public void setMstscAdslTitle(String mstscAdslTitle) {
        this.mstscAdslTitle = mstscAdslTitle;
    }

    public String getMstscAdslName() {
        return mstscAdslName;
    }

    public void setMstscAdslName(String mstscAdslName) {
        this.mstscAdslName = mstscAdslName;
    }

    public String getMstscAdslPass() {
        return mstscAdslPass;
    }

    public void setMstscAdslPass(String mstscAdslPass) {
        this.mstscAdslPass = mstscAdslPass;
    }

    public Date getMstscEndTime() {
        return mstscEndTime;
    }

    public void setMstscEndTime(Date mstscEndTime) {
        this.mstscEndTime = mstscEndTime;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getVpsProt() {
        return vpsProt;
    }

    public void setVpsProt(String vpsProt) {
        this.vpsProt = vpsProt;
    }

    public Date getVpsOverTime() {
        return vpsOverTime;
    }

    public void setVpsOverTime(Date vpsOverTime) {
        this.vpsOverTime = vpsOverTime;
    }

    public String getVpsRegion() {
        return vpsRegion;
    }

    public void setVpsRegion(String vpsRegion) {
        this.vpsRegion = vpsRegion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Integer getSinaRunTime() {
        return sinaRunTime;
    }

    public void setSinaRunTime(Integer sinaRunTime) {
        this.sinaRunTime = sinaRunTime;
    }

    public String getIsUploadAccount() {
        return isUploadAccount;
    }

    public void setIsUploadAccount(String isUploadAccount) {
        this.isUploadAccount = isUploadAccount;
    }
}
