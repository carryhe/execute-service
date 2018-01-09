package com.hongkun.execute.business.service;

import java.util.Map;

/**
 * @author HeXG
 * @since 2018/1/9
 */
public interface SinaOrderFansService {

    Map<Integer,String> getFansOrder(String accountUid);

    void saveOrderFans(Map<String, String> result);

    void updateState(String flag,Integer id);
}
