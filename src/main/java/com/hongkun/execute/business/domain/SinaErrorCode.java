package com.hongkun.execute.business.domain;

/**
 * @author HeXG
 * @since 2018/1/3
 */
public class SinaErrorCode {
    /*
    `id` int(11) NOT NULL,
    `error_code` varchar(255) NOT NULL,
    `error_ description` varchar(255) NOT NULL
    */
    private Integer id;
    private String errorCode;
    private String errorDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
