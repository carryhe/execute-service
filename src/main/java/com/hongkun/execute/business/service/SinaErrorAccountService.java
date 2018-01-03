package com.hongkun.execute.business.service;

import com.hongkun.execute.business.domain.SinaAccount;

import java.util.List; /**
 * @author HeXG
 * @since 2018/1/3
 */
public interface SinaErrorAccountService {
    Integer insertErrorSinaAccount(List<SinaAccount> sinaAccounts);
}
