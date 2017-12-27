package com.hongkun.execute.business.dao;

import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.common.dto.GetSinaAccountDto;
import com.hongkun.execute.common.dto.UpdateSinaAccountDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author HeXG
 * @since 2017/12/26
 */
public interface SinaAccountDao {

    /**
     * 批量添加
     * @param
     * @return
     */
    public int insertMult(List<SinaAccount> t);

    /**
     * 获取一个账号
     * @param sinaVpsRegion
     * @return
     */
    public List<SinaAccount> getSinaAccount(@Param("sinaVpsRegion") String sinaVpsRegion);

    /**
     * 修改用户的sina状态
     */
    void updateSinaAccount(@Param("id") Integer id,@Param("mstscId")String mstscId);

    /**
     * 修改值根据id
     * @param updateSinaAccountDto
     */
    void updateSinaAccountById(UpdateSinaAccountDto updateSinaAccountDto);
    
    /**
     * 查询一条记录
     * @param condition
     * @return
     */
    SinaAccount findQueryOne(Map<String,Object> condition) throws Exception;
}
