package com.hongkun.execute.business.controller;


import org.apache.commons.codec.digest.DigestUtils;

import com.hongkun.execute.backstage.util.ResultView;

/**
 * 控制层基类
 *
 * @author 张超
 * @since 2017/12/14
 */
public class BaseController {
    /**
     * 返回正常json数据
     *
     * @return 封装的json数据
     */
    public ResultView success() {
        ResultView resultView = new ResultView();
        resultView.setSuccess(true);
        return resultView;
    }

    /**
     * 返回正常带message的json数据
     *
     * @param message 信息
     * @return 封装的json数据
     */
    public ResultView success(String message) {
        ResultView resultView = new ResultView();
        resultView.setSuccess(true);
        resultView.setMessage(message);
        return resultView;
    }

    /**
     * 返回正常json数据
     *
     * @param data 数据
     * @return 封装的json数据
     */
    public ResultView success(Object data) {
        ResultView resultView = new ResultView();
        resultView.setSuccess(true);
        resultView.setData(data);
        return resultView;
    }

    /**
     * 返回包含成功信息的正常json数据
     *
     * @param message 成功信息
     * @param data    其他数据
     * @return 封装的json数据
     */
    public ResultView success(String message, Object data) {
        ResultView resultView = success(data);
        resultView.setMessage(message);
        return resultView;
    }

    /**
     * 返回带信息的错误处理
     *
     * @param message 错误信息
     * @return 封装的json数据
     */
    public ResultView error(String message) {
        ResultView resultView = new ResultView();
        resultView.setSuccess(false);
        resultView.setMessage(message);
        return resultView;
    }

    /**
     * 返回带数据的错误json数据
     *
     * @param message 错误信息
     * @param data    数据
     * @return 封装的json数据
     */
    public ResultView error(String message, Object data) {
        ResultView resultView = error(message);
        resultView.setData(data);
        return resultView;
    }

    /**
     * 进行访问api的权限控制
     *
     * @param security
     * @return
     */
    public boolean verifyAuthority(String temp, String security) {
        String md5Hex = DigestUtils.md5Hex(temp);
        return security.equals(md5Hex);
    }
}
