package com.hongkun.execute.business.service.impl;

import com.google.gson.Gson;
import com.hongkun.execute.business.dao.SinaAccountDao;
import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.business.service.SinaAccountService;
import com.hongkun.execute.common.dto.GetSinaAccountDto;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HeXG
 * @since 2017/12/26
 */
@Service("sinaAccountService")
public class SinaAccountServiceImpl implements SinaAccountService {

    @Resource
    private SinaAccountDao sinaAccountDao;

    @Override
    public void saveSinaAccount(String jsons) {
        List<SinaAccount> parsers = parser(jsons);
        int insertMult = sinaAccountDao.insertMult(parsers);
    }

    @Override
    public GetSinaAccountDto getSinaAccount(String sinaVpsRegion, String mstscId) {
        GetSinaAccountDto sinaAccountDto=null;
        /**
         * 获取到一个账号，然后在改变账号的使用状态
         */
        List<SinaAccount> sinaAccounts = sinaAccountDao.getSinaAccount(mstscId, sinaVpsRegion);
        if (CollectionUtils.isNotEmpty(sinaAccounts)) {
            SinaAccount sinaAccount = sinaAccounts.get(0);
            Integer id = sinaAccount.getId();
            //修改此id用户的服务器状态
            sinaAccountDao.updateSinaAccount(id,mstscId);
            sinaAccountDto = new GetSinaAccountDto();
            sinaAccountDto.setId(id);
            sinaAccountDto.setSinaAccount(sinaAccount.getSinaAccount());
            sinaAccountDto.setSinaPass(sinaAccount.getSinaPass());
            sinaAccountDto.setSinaVpsRegion(sinaAccount.getSinaVpsRegion());
        }
        return sinaAccountDto;
    }

    @Override
    public void updateSinaAccount(Integer id,String sinaToken,String sinaErrorCode,String sinaUid,String sinaAccount,Integer forwardNum) {
        //根据账户的id来修改账户信息并清除mstscId
        sinaAccountDao.updateSinaAccountById(id,sinaToken,sinaErrorCode,sinaUid,sinaAccount,forwardNum);
    }


    /**
     * 解析json字符串
     * @param jsons
     */
    private List<SinaAccount> parser(String jsons) {
        List<SinaAccount> result = null;
        Gson gson = new Gson();
        Map<String,Object> temp=new HashMap<>();
        Map<String,List> map = gson.fromJson(jsons, temp.getClass());
        List data = map.get("data");
        if (CollectionUtils.isNotEmpty(data)){
            result=new ArrayList<>();
            for (int i = 0; i <data.size() ; i++) {
                SinaAccount sinaAccount = new SinaAccount();
                Object o = data.get(i);
                String s = gson.toJson(o);
                Map<String,Object> map1 = gson.fromJson(s, Map.class);
                sinaAccount.setSinaAccount((String) map1.get("accountName"));
                sinaAccount.setSinaPass((String) map1.get("accountPassword"));
                sinaAccount.setSinaUid((String) map1.get("accountType"));
                sinaAccount.setSinaVpsRegion((String) map1.get("region"));
                result.add(sinaAccount);
            }
        }
        return result;
    }

	@Override
	public SinaAccount updatefindQueryOne(Map<String, Object> condition,String mstscId)throws Exception{
		SinaAccount sinaAccount  = sinaAccountDao.findQueryOne(condition);
		if(sinaAccount != null) {
			sinaAccount.setMstscId(mstscId);
			sinaAccountDao.updateById(sinaAccount);
		}
		return sinaAccount;
	}

    @Override
    public List<SinaAccount> findErrorAccountByErrorCode(String errorCode) {
        return sinaAccountDao.findErrorAccountByErrorCode(errorCode);
    }

    @Override
    public void delErrorAccountByErrorCode(String errorCode) {
        sinaAccountDao.delErrorAccountByErrorCode(errorCode);
    }

}
