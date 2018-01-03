package com.hongkun.execute.business.dao;

import com.hongkun.execute.business.domain.SinaAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/3
 */
@Component
@Mapper
public interface SinaErrorAccountDao {
    public Integer insertErrorSinaAccount(List<SinaAccount> sinaAccounts);
}
