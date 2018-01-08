package com.hongkun.execute.business.dao;

import com.hongkun.execute.business.domain.MstscConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/8
 */
@Mapper
@Component
public interface MstscConfigDao {

    MstscConfig getMstscConfigById(Integer id);

    List<String> getAllRegions();
}
