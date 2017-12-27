package com.hongkun.execute.business.service;

import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.common.dto.GetSinaAccountDto;
import com.hongkun.execute.common.dto.UpdateSinaAccountDto;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

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
    void updateSinaAccount(UpdateSinaAccountDto updateSinaAccountDto);
    
    SinaAccount findQueryOne(Map<String,Object> condition)  throws Exception;
}
