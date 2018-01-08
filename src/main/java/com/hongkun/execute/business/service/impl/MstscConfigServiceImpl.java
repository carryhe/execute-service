package com.hongkun.execute.business.service.impl;


import com.hongkun.execute.business.dao.MstscConfigDao;
import com.hongkun.execute.business.domain.MstscConfig;
import com.hongkun.execute.business.service.MstscConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/8
 */
@Service("mstscconfigService")
public class MstscConfigServiceImpl implements MstscConfigService {

    @Resource
    private MstscConfigDao mstscConfigDao;


    @Override
    public MstscConfig getMstscConfigById(Integer id) {
        return mstscConfigDao.getMstscConfigById(id);
    }

    @Override
    public List<String> getAllRegions() {
        return mstscConfigDao.getAllRegions();
    }
}
