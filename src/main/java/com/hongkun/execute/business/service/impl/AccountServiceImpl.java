package com.hongkun.execute.business.service.impl;

import com.google.gson.Gson;
import com.hongkun.execute.business.dao.AccountDao;
import com.hongkun.execute.business.domain.Account;
import com.hongkun.execute.business.service.AccountService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HeXG
 * @since 2018/1/4
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void saveAccount(String jsons) {
        List<Account> parsers = parser(jsons);
        accountDao.saveAccount(parsers);
    }

    @Override
    public List<Account> findAccountByRegionLimit(String region, Integer num) {
        return accountDao.findAccountByRegionLimit(region, num);
    }

    @Override
    public void updateAccountState(List<Integer> ids) {
        accountDao.updateAccountState(ids);
    }


    /**
     * 解析添加的字符串
     * @param jsons
     * @return
     */
    private List<Account> parser(String jsons) {
        List<Account> result = null;
        Gson gson = new Gson();
        Map<String,Object> temp=new HashMap<>();
        Map<String,List> map = gson.fromJson(jsons, temp.getClass());
        List data = map.get("data");
        if (CollectionUtils.isNotEmpty(data)){
            result=new ArrayList<>();
            for (int i = 0; i <data.size() ; i++) {
                Account account = new Account();
                Object o = data.get(i);
                String s = gson.toJson(o);
                Map<String,Object> map1 = gson.fromJson(s, Map.class);
                account.setAccountName((String) map1.get("accountName"));
                account.setAccountPassword((String) map1.get("accountPassword"));
                account.setAccountUid((String) map1.get("accountUid"));
                account.setRegion((String) map1.get("region"));
                result.add(account);
            }
        }
        return result;
    }
}
