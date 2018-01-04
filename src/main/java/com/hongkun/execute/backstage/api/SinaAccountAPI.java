package com.hongkun.execute.backstage.api;

import com.hongkun.execute.backstage.util.ResultView;
import com.hongkun.execute.business.controller.BaseController;
import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.business.service.SinaAccountService;
import com.hongkun.execute.common.dto.GetSinaAccountDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HeXG
 * @since 2017/12/26
 * 处理
 */
@Controller
@RequestMapping("api/sinaAccount/")
public class SinaAccountAPI extends BaseController {

    @Resource
    private SinaAccountService sinaAccountService;

    String con = "con";
    /**
     * 向sina_account表中添加信息的api。
     * @param jsons
     * @param security
     * @return
     */
    @RequestMapping("saveSinaAccount")
    @ResponseBody
    public ResultView saveSinaAccount(String jsons,String security){
        //@todo 进行加密的常量。
        String temp = jsons + con;
        boolean b = verifyAuthority(temp, security);
        if (!b){
            return error("权限认证失败");
        }
        if (StringUtils.isBlank(jsons)){
            return error("传入的参数不能为空");
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
        String temp = sinaVpsRegion+mstscId+ con;
        boolean b = verifyAuthority(temp, security);
        if (!b){
            return error("权限认证失败");
        }
        if (StringUtils.isBlank(sinaVpsRegion)||StringUtils.isBlank(mstscId)){
            return error("传入的参数不能为空");
        }
        GetSinaAccountDto sinaAccountDto=sinaAccountService.getSinaAccount(sinaVpsRegion,mstscId);
        if (sinaAccountDto==null){
            return success("您输入的信息，没查询到数据");
        }
        return success("success",sinaAccountDto);
    }


    @RequestMapping("updateSinaAccount")
    @ResponseBody
    public ResultView updateSinaAccount(Integer id,
                                        @RequestParam(value = "sinaToken",defaultValue = "") String sinaToken,
                                        @RequestParam(value = "sinaErrorCode",defaultValue = "")String sinaErrorCode,
                                        @RequestParam(value = "sinaUid",defaultValue = "")String sinaUid,
                                        @RequestParam(value = "sinaAccount",defaultValue = "")String sinaAccount,
                                        Integer forwardNum,
                                        String security){
        String temp = id+sinaToken+sinaErrorCode+sinaUid+sinaAccount+(forwardNum==null?"":forwardNum )+ con;
        boolean b = verifyAuthority(temp, security);
        if (!b){
            return error("权限认证失败");
        }
        sinaAccountService.updateSinaAccount(id,sinaToken,sinaErrorCode,sinaUid,sinaAccount,forwardNum);
        return success("success");
    }



   
    /**
     * 查找状态为执行中的所有数据
     * @param sinaVpsRegion  地区名
     * @param security       加密
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/findQueryOne",method = RequestMethod.POST)
    @ResponseBody
    public ResultView findQueryOne(String mstscId,String sinaVpsRegion,String security) throws Exception {
        String temp = mstscId + sinaVpsRegion + con;
        boolean b = verifyAuthority(temp, security);
        if (!b){
            return error("权限认证失败");
        }
        //获取当前时间小于21小时
        long currentTime = System.currentTimeMillis() ;
        currentTime -=21*60*60*1000;
        Date date=new Date(currentTime);
        //创建map对象
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("time", date);
        condition.put("mstscId", mstscId);
        condition.put("region", sinaVpsRegion);
        SinaAccount sinaAccount = sinaAccountService.updatefindQueryOne(condition,mstscId);
        return success(sinaAccount);
    }
}
