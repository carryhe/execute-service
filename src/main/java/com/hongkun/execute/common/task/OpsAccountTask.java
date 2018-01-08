package com.hongkun.execute.common.task;

import com.hongkun.execute.business.domain.Account;
import com.hongkun.execute.business.service.AccountService;
import com.hongkun.execute.business.service.MstscConfigService;
import com.hongkun.execute.business.service.SinaAccountService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private MstscConfigService mstscConfigService;

    /**
     * 将account中的账号添加到sina_account中
     */
    @Scheduled(fixedRate = 1000 * 20)
    @Transactional(rollbackFor = Exception.class)
    public void dealAccountNum() {
        //查询sina_account账户，返回账户的条数，地区
        List<SinaAccountNumAndRegion> numAndRegions = sinaAccountService.findSinaAccountNumAndRegion();
        //查询地区表
        List<String> regions = mstscConfigService.getAllRegions();
        //将sina_account表中出现过的地址去掉。
        List<String> removeRegions = null;
        if (CollectionUtils.isNotEmpty(numAndRegions)) {
            removeRegions = new ArrayList<>();
            //获取到地区以及数量
            for (SinaAccountNumAndRegion sinaAccountNumAndRegion : numAndRegions) {
                //将地区，存入到移除的list中
                removeRegions.add(sinaAccountNumAndRegion.getRegion());

                Integer num = 100 - sinaAccountNumAndRegion.getNumber();
                if (num > 0) {
                    //进行查询account中的账号，修改这些账号的state为 转发账号
                    List<Account> accounts = accountService.findAccountByRegionLimit(sinaAccountNumAndRegion.getRegion(), num);
                    if (CollectionUtils.isNotEmpty(accounts)) {
                        //将这些账号批量添加到sina_account中
                        sinaAccountService.insertSinaAccount(accounts);
                        //获取ids,修改account中的state为转发账号
                        List<Integer> ids = new ArrayList<>();
                        for (Account account : accounts) {
                            ids.add(account.getId());
                        }
                        accountService.updateAccountState(ids);
                    }
                }
            }
        }
        //去掉sina_account出现过的地址
        if (CollectionUtils.isNotEmpty(removeRegions)) {
            regions.removeAll(removeRegions);
        }
        if (CollectionUtils.isNotEmpty(regions)) {
            for (String region : regions) {
                //进行查询account中的账号
                List<Account> accounts = accountService.findAccountByRegionLimit(region, 100);
                if (null!=accounts&&accounts.size()>0) {
                    //将这些账号批量添加到sina_account中
                    sinaAccountService.insertSinaAccount(accounts);
                    //获取ids,修改account中的state为转发账号
                    List<Integer> ids = new ArrayList<>();
                    for (Account account : accounts) {
                        ids.add(account.getId());
                    }
                    accountService.updateAccountState(ids);
                }
            }
            }
        }



    }



