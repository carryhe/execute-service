package com.hongkun.execute.business.service.impl;

import com.hongkun.execute.business.dao.OrderFansDao;
import com.hongkun.execute.business.dao.SinaOrderFansDao;
import com.hongkun.execute.business.service.SinaOrderFansService;
import com.hongkun.execute.common.dto.FansOrder;
import com.hongkun.execute.common.mybatis.DataSourceContextHolder;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HeXG
 * @since 2018/1/9
 */
@Service("sinaOrderFansService")
public class SinaOrderFansServiceImpl implements SinaOrderFansService {

    @Resource
    private SinaOrderFansDao sinaOrderFansDao;

    @Resource
    private OrderFansDao orderFansDao;


    @Override
    public Map<Integer, String> getFansOrder(String accountUid) {
        Map<Integer, String> result = null;
        //完成的订单
        Integer flag = Integer.parseInt(accountUid) % 2000;
        List<Integer> finishids = orderFansDao.getOrderFans(accountUid, flag);
        //更换数据源
        DataSourceContextHolder.setDbType("orderdataSource");
        List<FansOrder> fansOrders = sinaOrderFansDao.getFansOrderByOid(finishids);
        if (CollectionUtils.isNotEmpty(fansOrders)) {
            result=new HashMap<>();
            for (FansOrder fansOrder : fansOrders) {
                result.put(fansOrder.getId(),fansOrder.getOid());
            }
        }
        return result;
    }

    @Override
    public void saveOrderFans(Map<String, String> result) {

        String accountUid = result.get("accountUid");
        Integer flag = Integer.parseInt(accountUid) % 2000;
        orderFansDao.saveOrderFans( result.get("orderUid"),accountUid,flag);
    }

    @Override
    public void updateState(String flag,Integer id) {
        //更换数据源
        DataSourceContextHolder.setDbType("orderdataSource");
        sinaOrderFansDao.updateState(flag,id);
    }
}
