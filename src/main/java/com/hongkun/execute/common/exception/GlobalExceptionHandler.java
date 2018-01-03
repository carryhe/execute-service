package com.hongkun.execute.common.exception;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;
import com.hongkun.execute.backstage.util.ResultView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * controller统一异常处理
 *
 * @author 张超
 * @since 2017/12/13
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //默认返回的异常页面
    private static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 处理所有异常
     * @param req 请求
     * @param resp 响应
     * @param e 异常
     * @return 数据视图
     * @throws Exception 异常
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req,HttpServletResponse resp, Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        String errorMsg = e.getMessage();
        String errorStack = Throwables.getStackTraceAsString(e);

        logger.error("Request: {} raised {}", req.getRequestURI(), errorStack);

        if (isAjaxRequest(req)) {
            return handleAjaxError(resp, errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return handleViewError(req.getRequestURL().toString(), errorStack, errorMsg);
    }

    /**
     * 处理视图异常
     * @param url 请求地址
     * @param errorStack 错误栈
     * @param errorMessage 错误信息
     * @return 数据视图
     */
    private ModelAndView handleViewError(String url, String errorStack, String errorMessage) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", errorStack);
        mav.addObject("url", url);
        mav.addObject("message", errorMessage);
        mav.addObject("timestamp", new Date());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * 处理ajax异常
     * @param rsp 响应
     * @param errorMessage 错误信息
     * @param status 状态
     * @return 响应
     * @throws IOException 异常
     */
    private ModelAndView handleAjaxError(HttpServletResponse rsp, String errorMessage, HttpStatus status) throws IOException {
        rsp.setCharacterEncoding("UTF-8");
        rsp.setStatus(status.value());
        PrintWriter writer = rsp.getWriter();
        ResultView resultView = new ResultView(false);
        resultView.setMessage(errorMessage);
        writer.write(JSON.toJSONString(resultView));
        writer.flush();
        return null;
    }
    /**
     * 判断是否为Ajax请求
     * @param request   HttpServletRequest
     * @return  是true, 否false
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        return requestType != null && "XMLHttpRequest".equals(requestType);
    }

}
