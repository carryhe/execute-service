package com.hongkun.execute.backstage.api;

import com.hongkun.execute.backstage.util.ResultView;
import com.hongkun.execute.business.controller.BaseController;
import com.hongkun.execute.business.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author HeXG
 * @since 2018/1/4
 */
@Controller
@RequestMapping("api/account/")
public class AccountAPI extends BaseController {

    @Resource
    private AccountService accountService;


    String con = "con";
    /**
     * 向account表中添加信息的api。
     * @param jsons
     * @param security
     * @return
     */
    @RequestMapping("saveAccount")
    @ResponseBody
    public ResultView saveAccount(String jsons, String security){
        //@todo 进行加密的常量。
        String temp = jsons + con;
        boolean b = verifyAuthority(temp, security);
        if (!b){
            return error("权限认证失败");
        }
        if (StringUtils.isBlank(jsons)){
            return error("传入的参数不能为空");
        }
        accountService.saveAccount(jsons);
        return success("success");
    }



}
