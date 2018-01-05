package com.hongkun.execute.common.task;

import com.hongkun.execute.business.domain.Account;
import com.hongkun.execute.business.service.AccountService;
import com.hongkun.execute.business.service.SinaAccountService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/4
 */
@Component
public class OpsAccountTask {

    @Resource
    private SinaAccountService sinaAccountService;
    @Resource
    private AccountService accountService;

    /**
     * 将account中的账号添加到sina_account中
     */
   @Scheduled(fixedRate = 1000 * 20)
    public void dealAccountNum(){
        //查询sina_account账户，返回账户的条数，地区
        List<SinaAccountNumAndRegion> numAndRegions =sinaAccountService.findSinaAccountNumAndRegion();
        if (CollectionUtils.isNotEmpty(numAndRegions)){
            //获取到地区以及数量
            for(SinaAccountNumAndRegion sinaAccountNumAndRegion:numAndRegions){
                Integer num = 100-sinaAccountNumAndRegion.getNumber();
                if (num>0){
                    //进行查询account中的账号，修改这些账号的state为 转发账号
                    List<Account> accounts=accountService.findAccountByRegionLimit(sinaAccountNumAndRegion.getRegion(),num);
                    if (CollectionUtils.isNotEmpty(accounts)) {
                        //将这些账号批量添加到sina_account中
                        sinaAccountService.insertSinaAccount(accounts);
                        //获取ids,修改account中的state为转发账号
                        List<Integer> ids = new ArrayList<>();
                        for (Account account :accounts){
                            ids.add(account.getId());
                        }
                        accountService.updateAccountState(ids);
                    }
                }
            }
        }


    }


}
