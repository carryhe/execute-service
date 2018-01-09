package com.hongkun.execute.business.dao;

import com.hongkun.execute.common.dto.FansOrder;
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
public interface SinaOrderFansDao {
    /**
     * 根据oid来获取id
     * @return
     */
    List<FansOrder> getFansOrderByOid(List<Integer> ids);

    void updateState(@Param("flag") String flag, @Param("id") Integer id);
}
