package com.hongkun.execute.common.dto;

/**
 * @author HeXG
 * @since 2017/12/26
 */
public class UpdateSinaAccountDto {
    private Integer id;
    private String sinaToken;
    private String sinaErrorCode;
    private String sinaUid;
    private String sinaAccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSinaToken() {
        return sinaToken;
    }

    public void setSinaToken(String sinaToken) {
        this.sinaToken = sinaToken;
    }

    public String getSinaErrorCode() {
        return sinaErrorCode;
    }

    public void setSinaErrorCode(String sinaErrorCode) {
        this.sinaErrorCode = sinaErrorCode;
    }

    public String getSinaUid() {
        return sinaUid;
    }

    public void setSinaUid(String sinaUid) {
        this.sinaUid = sinaUid;
    }

    public String getSinaAccount() {
        return sinaAccount;
    }

    public void setSinaAccount(String sinaAccount) {
        this.sinaAccount = sinaAccount;
    }
}
