package com.hongkun.execute.business.service;

import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.common.dto.GetSinaAccountDto;
import org.springframework.transaction.annotation.Transactional;

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
}
