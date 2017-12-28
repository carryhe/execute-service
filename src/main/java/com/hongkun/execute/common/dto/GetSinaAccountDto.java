package com.hongkun.execute.common.dto;

/**
 * @author HeXG
 * @since 2017/12/26
 */
public class GetSinaAccountDto {
    private String sinaAccount;
    private String sinaPass;
    private Integer id;
    private String sinaVpsRegion;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSinaVpsRegion() {
        return sinaVpsRegion;
    }

    public void setSinaVpsRegion(String sinaVpsRegion) {
        this.sinaVpsRegion = sinaVpsRegion;
    }


}
