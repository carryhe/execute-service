package com.hongkun.execute.business.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/9
 */
@Mapper
@Component
public interface OrderFansDao {
    /**
     * 根据accountUid查询出ids
     * @param accountUid
     * @return
     */
    List<String> getOrderFans(@Param("accountUid") String accountUid, @Param("flag") Long flag);

    /**
     * 存入到 order_fans表中
     */
    void saveOrderFans(@Param("orderUid") String orderUid, @Param("accountUid") String accountUid, @Param("flag") Long flag);


}
