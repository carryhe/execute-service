package com.hongkun.execute.business.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hongkun.execute.backstage.util.ResultView;
import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.business.service.SinaAccountService;


@Controller
@RequestMapping("sinaAccount")
public class SinaAccountController extends BaseController{
    
	@Resource
    private  SinaAccountService sinaAccountService;
	
	String con = "con";
	/**
	 * 查找状态为执行中的所有数据
	 * @param sinaVpsRegion  地区名
	 * @param security       加密
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="finQueryOne",method = RequestMethod.POST)
    @ResponseBody
	public ResultView finQueryOne(String mstscId,String sinaVpsRegion,String security) throws Exception {
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
		condition.put("region", sinaVpsRegion);
		SinaAccount sinaAccount = sinaAccountService.updatefindQueryOne(condition,mstscId);
		return success(sinaAccount);
	}
    

}
