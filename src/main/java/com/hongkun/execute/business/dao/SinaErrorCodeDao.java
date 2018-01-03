package com.hongkun.execute.business.dao;

import com.hongkun.execute.business.domain.SinaErrorCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HeXG
 * @since 2018/1/3
 */
@Mapper
@Component
public interface SinaErrorCodeDao {

    public List<SinaErrorCode> findSinaErrorCode();
}
