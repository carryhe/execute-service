package com.hongkun.execute.backstage.api;

import com.hongkun.execute.backstage.util.ResultView;
import com.hongkun.execute.business.controller.BaseController;
import com.hongkun.execute.business.domain.MstscConfig;
import com.hongkun.execute.business.service.MstscConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author HeXG
 * @since 2018/1/8
 */
@Controller
@RequestMapping("api/mstscConfig/")
public class MstscConfigAPI extends BaseController{
    //todo 加密字段，可以常量处理
    private String con="con";

    @Resource
    private MstscConfigService mstscConfigService;

    /**
     * 向account表中添加信息的api。
     * @param id
     * @param security
     * @return
     */
    @RequestMapping("getMstscConfig")
    @ResponseBody
    public ResultView getMstscConfigById(Integer id, String security){
        String temp = id + con;
        boolean b = verifyAuthority(temp, security);
        if (!b){
            return error("权限认证失败");
        }

        MstscConfig mstscConfig=mstscConfigService.getMstscConfigById(id);
        if (null==mstscConfig){
            return error("没查询到数据");
        }

        return success("success",mstscConfig);
    }
}
