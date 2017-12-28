package com.hongkun.execute.business.dao;

import com.hongkun.execute.business.domain.SinaAccount;
import org.apache.ibatis.annotations.Param;

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
     * @param
     */
    void updateSinaAccountById(@Param("id") Integer id,
                               @Param("sinaToken") String sinaToken,
                               @Param("sinaErrorCode") String sinaErrorCode,
                               @Param("sinaUid") String sinaUid,
                               @Param("sinaAccount") String sinaAccount,
                               @Param("forwardNum") Integer forwardNum);
    
    /**
     * 查询一条记录
     * @param condition
     * @return
     */
    SinaAccount findQueryOne(Map<String,Object> condition) throws Exception;
    
    int updateById(SinaAccount sinaAccount);
}
