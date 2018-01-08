package com.hongkun.execute.business.service;

import com.hongkun.execute.business.domain.MstscConfig;

import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/8
 */
public interface MstscConfigService  {

    /**
     * 根据id，获取地区
     * @param id
     * @return
     */
    MstscConfig getMstscConfigById(Integer id);

    /**
     * 查询出所有的地址
     * @return
     */
    List<String> getAllRegions();
}
