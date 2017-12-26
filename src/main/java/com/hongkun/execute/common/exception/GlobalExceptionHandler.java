package com.hongkun.execute.common.exception;

import com.hongkun.execute.common.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * controller统一异常处理
 *
 * @author 张超
 * @since 2017/12/13
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //默认返回的异常页面
    private static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 处理一般异常
     *
     * @param req 请求
     * @param e   异常
     * @return 数据视图
     * @throws Exception 异常
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * 处理ajax请求返回的异常
     *
     * @param req 请求
     * @param e   异常
     * @return 数据视图
     * @throws Exception 异常
     */
    @ExceptionHandler(value = MyJsonException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyJsonException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

}
