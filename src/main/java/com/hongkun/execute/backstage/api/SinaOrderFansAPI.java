package com.hongkun.execute.backstage.api;

import com.google.gson.Gson;
import com.hongkun.execute.backstage.util.RedisService;
import com.hongkun.execute.backstage.util.ResultView;
import com.hongkun.execute.business.controller.BaseController;
import com.hongkun.execute.business.service.SinaOrderFansService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HeXG
 * @since 2018/1/9
 */
@Controller
@RequestMapping("api/sinaOrderFans")
public class SinaOrderFansAPI extends BaseController {

    @Resource
    private SinaOrderFansService sinaOrderFansService;

    @Resource
    private RedisService redisService;


    String con = "con";

    @RequestMapping("getFansOrder")
    @ResponseBody
    public ResultView getFansOrder(String accountUid, String security) {
        String temp = accountUid + con;
        boolean b = verifyAuthority(temp, security);
        if (!b) {
            return error("权限认证失败");
        }
        if (StringUtils.isBlank(accountUid)) {
            return error("传入的参数不能为空");
        }
        //id:oid
        Map<Integer, String> result = sinaOrderFansService.getFansOrder(accountUid);
        if (result.isEmpty()) {
            return error("没查询到订单信息");
        }
        return success("success", result);
    }

    @RequestMapping("dealResult")
    @ResponseBody
    public ResultView dealResult(String json, String security) {
        String temp = json + con;
        boolean b = verifyAuthority(temp, security);
        if (!b) {
            return error("权限认证失败");
        }
        if (StringUtils.isBlank(json)) {
            return error("传入的参数不能为空");
        }
        Map<String, String> result = analyze(json);
        if (!result.isEmpty()){
            String flag = result.get("result");
            Integer id = Integer.valueOf(result.get("id"));
            if ("成功".equals(flag)){
                //存入到数据库中
                sinaOrderFansService.saveOrderFans(result);
                //redis中的key加一
                String key ="fans_succ_"+ id;
                redisService.setKey(key);
            }
            if ("异常".equals(flag)){
                //修改表sina_order_fans 状态为异常
                sinaOrderFansService.updateState(flag,id);
            }
        }
        return success("success");
    }

    /**
     * 进行解析
     *
     * @param json
     * @return
     */
    private Map<String, String> analyze(String json) {
        Gson gson = new Gson();
        Map<String, String> result = new HashMap<>();
        result = gson.fromJson(json, result.getClass());
        return result;
    }
}
