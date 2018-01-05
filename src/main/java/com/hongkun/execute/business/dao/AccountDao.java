package com.hongkun.execute.business.dao;

import com.hongkun.execute.business.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/4
 */
@Mapper
@Component
public interface AccountDao {
    /**
     * 批量添加
     * @param parsers
     */
    public void saveAccount(List<Account> parsers);

    /**
     * 查询账号
     * @param region
     * @param num
     * @return
     */
    List<Account> findAccountByRegionLimit(@Param("region") String region, @Param("num") Integer num);

    /**
     * 批量的修改account的状态
     * @param ids
     */
    void updateAccountState(List<Integer> ids);
}
