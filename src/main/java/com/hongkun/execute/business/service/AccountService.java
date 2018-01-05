package com.hongkun.execute.business.service;

import com.hongkun.execute.business.domain.Account;

import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/4
 */
public interface AccountService {
    /**
     * 向account表中添加信息
     * @param jsons
     */
    void saveAccount(String jsons);

    /**
     * 查询账号
     * @param region
     * @param num
     * @return
     */
    List<Account> findAccountByRegionLimit(String region, Integer num);

    /**
     * 批量的修改account的状态
     * @param ids
     */
    void updateAccountState(List<Integer> ids);
}
