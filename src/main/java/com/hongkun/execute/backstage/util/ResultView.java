package com.hongkun.execute.backstage.util;

/**
 * 返回信息模板
 * @author 张超
 * @since 2017/12/12
 */
public class ResultView {
    private boolean success;
    private String message;
    private Object data;

    public ResultView(){
        this.success = true;
    }
    public ResultView(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
