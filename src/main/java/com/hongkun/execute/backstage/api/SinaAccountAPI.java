package com.hongkun.execute.backstage.api;

import com.hongkun.execute.backstage.util.ResultView;
import com.hongkun.execute.business.controller.BaseController;
import com.hongkun.execute.business.service.SinaAccountService;
import com.hongkun.execute.common.dto.GetSinaAccountDto;
import com.hongkun.execute.common.dto.UpdateSinaAccountDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.lang.model.element.NestingKind;

/**
 * @author HeXG
 * @since 2017/12/26
 * 处理
 */
@Controller
@RequestMapping("sinaAccountAPI")
public class SinaAccountAPI extends BaseController {

    @Resource
    private SinaAccountService sinaAccountService;

    /**
     * 向sina_account表中添加信息的api。
     * @param jsons
     * @param security
     * @return
     */
    @RequestMapping("saveSinaAccount")
    @ResponseBody
    public ResultView saveSinaAccount(String jsons,String security){
        /*String sinaAccount, String sinaPass, String sinaUid,String sinaVpsRegion*/
        //@todo 进行加密的常量。
        String con ="con";
        String temp = jsons + con;
        boolean b = verifyAuthority(temp, security);
        if (!b){
            return error("权限认证失败");
        }
        sinaAccountService.saveSinaAccount(jsons);
        return success("success");
    }
    /**
     * 获取账号信息
     * @param sinaVpsRegion
     * @param mstscId
     * @param security
     * @return
     */
    @RequestMapping("getSinaAccount")
    @ResponseBody
    public synchronized ResultView getSinaAccount(String sinaVpsRegion,String mstscId,String security){
//        if (StringUtils.isBlank(sinaVpsRegion)||StringUtils.isBlank(mstscId)){
//            return error("传入的参数不能为空");
//        }
//        //@todo 进行加密的常量。
//        String con ="con";
//        String temp = sinaVpsRegion+mstscId+ con;
//        boolean b = verifyAuthority(temp, security);
//        if (!b){
//            return error("权限认证失败");
//        }
        GetSinaAccountDto sinaAccountDto=sinaAccountService.getSinaAccount(sinaVpsRegion,mstscId);
        if (sinaAccountDto==null){
            return success("您输入的信息，没查询到数据");
        }
        return success("success",sinaAccountDto);
    }


    @RequestMapping("updateSinaAccount")
    @ResponseBody
    public ResultView updateSinaAccount(UpdateSinaAccountDto updateSinaAccountDto, String security){
        //@todo 进行加密的常量。
//        String con ="con";
//        String temp = updateSinaAccountDto + con;
//        boolean b = verifyAuthority(temp, security);
//        if (!b){
//            return error("权限认证失败");
//        }
        sinaAccountService.updateSinaAccount(updateSinaAccountDto);
        return success("success");
    }



    /**
     * 进行访问api的权限控制
     * @param security
     * @return
     */
    private boolean verifyAuthority(String temp,String security){
        String md5Hex = DigestUtils.md5Hex(temp);
        if (!security.equals(md5Hex)) {
            return false;
        }
        return true;
    }


}
