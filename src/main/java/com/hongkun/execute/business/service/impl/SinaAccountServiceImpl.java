package com.hongkun.execute.business.service.impl;

import com.google.gson.Gson;
import com.hongkun.execute.business.dao.SinaAccountDao;
import com.hongkun.execute.business.domain.Account;
import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.business.service.SinaAccountService;
import com.hongkun.execute.common.dto.GetSinaAccountDto;
import com.hongkun.execute.common.task.SinaAccountNumAndRegion;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HeXG
 * @since 2017/12/26
 */
@Service("sinaAccountService")
public class SinaAccountServiceImpl implements SinaAccountService {

    @Resource
    private SinaAccountDao sinaAccountDao;

    @Override
    public void saveSinaAccount(String jsons) {
        List<SinaAccount> parsers = parser(jsons);
        int insertMult = sinaAccountDao.insertMult(parsers);
    }

    @Override
    public GetSinaAccountDto getSinaAccount(String sinaVpsRegion, String mstscId) {
        GetSinaAccountDto sinaAccountDto = null;
        /**
         * 获取到一个账号，然后在改变账号的使用状态
         */
        List<SinaAccount> sinaAccounts = sinaAccountDao.getSinaAccount(mstscId, sinaVpsRegion);
        if (CollectionUtils.isNotEmpty(sinaAccounts)) {
            SinaAccount sinaAccount = sinaAccounts.get(0);
            Integer id = sinaAccount.getId();
            //修改此id用户的服务器状态
            sinaAccountDao.updateSinaAccount(id, mstscId);
            sinaAccountDto = new GetSinaAccountDto();
            sinaAccountDto.setId(id);
            sinaAccountDto.setSinaAccount(sinaAccount.getSinaAccount());
            sinaAccountDto.setSinaPass(sinaAccount.getSinaPass());
            sinaAccountDto.setSinaVpsRegion(sinaAccount.getSinaVpsRegion());
        }
        return sinaAccountDto;
    }

    @Override
    public void updateSinaAccount(Integer id, String sinaToken, String errorCode, String sinaUid, String sinaAccount, Integer forwardNum) {
        String code = "";
        String codeTime = "";
        Integer value = null;
        if (StringUtils.isNotBlank(errorCode)) {
            //解析sinaErrorCode
            String[] split = errorCode.split(":");
            code = split[0];
            switch (code) {
                case "sinaErrorCode":
                    code = "sina_error_code";
                    codeTime = "sina_error_time";
                    break;
                case "forwardErrorCode":
                    code = "forward_error_code";
                    codeTime = "forward_error_time";
                    break;
                case "fansErrorEode":
                    code = "fans_error_code";
                    codeTime = "fans_error_time";
                    break;
                case "likeErrorCode":
                    code = "like_error_code";
                    codeTime = "like_error_time";
                    break;
                default:
                    code = "";
            }
            value = Integer.parseInt(split[1]);
        }
        //根据账户的id来修改账户信息并清除mstscId
        sinaAccountDao.updateSinaAccountById(id, sinaToken, code, value, codeTime, sinaUid, sinaAccount, forwardNum);
    }


    /**
     * 解析json字符串
     *
     * @param jsons
     */
    private List<SinaAccount> parser(String jsons) {
        List<SinaAccount> result = null;
        Gson gson = new Gson();
        Map<String, Object> temp = new HashMap<>();
        Map<String, List> map = gson.fromJson(jsons, temp.getClass());
        List data = map.get("data");
        if (CollectionUtils.isNotEmpty(data)) {
            result = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                SinaAccount sinaAccount = new SinaAccount();
                Object o = data.get(i);
                String s = gson.toJson(o);
                Map<String, Object> map1 = gson.fromJson(s, Map.class);
                sinaAccount.setSinaAccount((String) map1.get("accountName"));
                sinaAccount.setSinaPass((String) map1.get("accountPassword"));
                sinaAccount.setSinaUid((String) map1.get("accountType"));
                sinaAccount.setSinaVpsRegion((String) map1.get("region"));
                result.add(sinaAccount);
            }
        }
        return result;
    }

    @Override
    public SinaAccount updatefindQueryOne(Map<String, Object> condition, String mstscId,String from) throws Exception {

        if (StringUtils.isNotBlank(from)) {
            switch (from) {
            case "forwardErrorCode":
                from = "forward_error_code";
                break;
            case "fansErrorEode":
                from = "fans_error_code";
                break;
            case "likeErrorCode":
                from = "like_error_code";
                break;
            default:
                from = "";
        }
    }
        condition.put("from",from);
        SinaAccount sinaAccount = sinaAccountDao.findQueryOne(condition);
        if (sinaAccount != null) {
            sinaAccount.setMstscId(mstscId);
            sinaAccountDao.updateById(sinaAccount);
        }
        return sinaAccount;
    }

    @Override
    public List<SinaAccount> findErrorAccountByErrorCode(String errorCode) {
        return sinaAccountDao.findErrorAccountByErrorCode(errorCode);
    }

    @Override
    public void delErrorAccountByErrorCode(String errorCode) {
        sinaAccountDao.delErrorAccountByErrorCode(errorCode);
    }

    @Override
    public List<SinaAccountNumAndRegion> findSinaAccountNumAndRegion() {
        return sinaAccountDao.findSinaAccountNumAndRegion();
    }

    @Override
    public void insertSinaAccount(List<Account> accounts) {
        sinaAccountDao.insertSinaAccount(accounts);
    }

}
