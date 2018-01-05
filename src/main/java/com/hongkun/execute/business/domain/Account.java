package com.hongkun.execute.business.domain;

/**
 * @author HeXG
 * @since 2018/1/4
 */
public class Account {

    private Integer id;
    private String accountName;
    private String accountPassword;
    private String accountUid;
    private String accountAddTime;
    private String region;
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(String accountUid) {
        this.accountUid = accountUid;
    }

    public String getAccountAddTime() {
        return accountAddTime;
    }

    public void setAccountAddTime(String accountAddTime) {
        this.accountAddTime = accountAddTime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
