package com.hongkun.execute.business.service.impl;

import com.hongkun.execute.business.dao.SinaErrorCodeDao;
import com.hongkun.execute.business.domain.SinaErrorCode;
import com.hongkun.execute.business.service.SinaErrorCodeService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/3
 */
@Service("sinaErrorCodeService")
public class SinaErrorCodeServiceImpl implements SinaErrorCodeService {

    @Resource
    private SinaErrorCodeDao sinaErrorCodeDao;

    @Override
    public List<String> findSinaErrorCode() {
        List<String> codes=null;
        List<SinaErrorCode> sinaErrorCodes = sinaErrorCodeDao.findSinaErrorCode();
        if (CollectionUtils.isNotEmpty(sinaErrorCodes)){
            codes=new ArrayList<>();
            for (SinaErrorCode  temp : sinaErrorCodes) {
                codes.add(temp.getErrorCode());
            }
        }
        return codes;
    }
}
