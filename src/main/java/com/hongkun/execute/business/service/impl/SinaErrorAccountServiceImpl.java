package com.hongkun.execute.business.service.impl;

import com.hongkun.execute.business.dao.SinaErrorAccountDao;
import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.business.service.SinaErrorAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/3
 */
@Service("sinaErrorAccountService")
public class SinaErrorAccountServiceImpl implements SinaErrorAccountService {
    @Resource
    private SinaErrorAccountDao sinaErrorAccountDao;
    @Override
    public Integer insertErrorSinaAccount(List<SinaAccount> sinaAccounts) {
       return sinaErrorAccountDao.insertErrorSinaAccount(sinaAccounts);
    }
}
