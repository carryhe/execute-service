package com.hongkun.execute.business.service;

import com.hongkun.execute.business.domain.Account;
import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.common.dto.GetSinaAccountDto;
import com.hongkun.execute.common.task.SinaAccountNumAndRegion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author HeXG
 * @since 2017/12/26
 */
public interface SinaAccountService {
    /**
     * 保存新浪账号信息的service层
     * @param jsons
     */
    void saveSinaAccount(String jsons);

    /**
     * 获取一个账号
     * @param sinaVpsRegion
     * @param mstscId
     * @return
     */
    @Transactional
    GetSinaAccountDto getSinaAccount(String sinaVpsRegion, String mstscId);

    /**
     * 根据主键id 来修改账户信息
     *
     */
    void updateSinaAccount(Integer id,String sinaToken,String sinaErrorCode,String sinaUid,String sinaAccount,Integer forwardNum);
    
    SinaAccount updatefindQueryOne(Map<String,Object> condition,String mstscId)  throws Exception;

    /**
     * 根据errorCode来查询订单
     * @param errorCode
     * @return
     */
    List<SinaAccount> findErrorAccountByErrorCode(String errorCode);

    /**
     * 根据error来删除
     * @param errorCode
     */
    void delErrorAccountByErrorCode(String errorCode);

    /**
     * 查询sina_account 中sina_error_code为空的数据
     * @return 数量以及地区
     */
    List<SinaAccountNumAndRegion> findSinaAccountNumAndRegion();

    /**
     * 将account中的账号给sinaAccount
     * @param accounts
     */
    void insertSinaAccount(List<Account> accounts);
}
