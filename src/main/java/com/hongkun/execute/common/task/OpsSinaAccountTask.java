package com.hongkun.execute.common.task;

import com.hongkun.execute.business.domain.SinaAccount;
import com.hongkun.execute.business.service.SinaAccountService;
import com.hongkun.execute.business.service.SinaErrorAccountService;
import com.hongkun.execute.business.service.SinaErrorCodeService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HeXG
 * @since 2017/12/27
 */
@Component
public class OpsSinaAccountTask {

    @Resource
    private SinaErrorCodeService sinaErrorCodeService;
    @Resource
    private SinaAccountService sinaAccountService;
    @Resource
    private SinaErrorAccountService sinaErrorAccountService;

    /**
     * 移动错误的订单
     */
    @Scheduled(fixedRate = 1000 * 20)
    public void dealErrorAccount() {
        //查询errorCode
        List<String> errorCodes = sinaErrorCodeService.findSinaErrorCode();
        if (CollectionUtils.isNotEmpty(errorCodes)) {
            for (String errorCode : errorCodes) {
                //根据errorCode来查询订单
                List<SinaAccount> sinaAccounts = sinaAccountService.findErrorAccountByErrorCode(errorCode);
                if (CollectionUtils.isNotEmpty(sinaAccounts)) {
                    //将sinaAccounts批量添加到sina——error-account中
                    sinaErrorAccountService.insertErrorSinaAccount(sinaAccounts);
                    //将sina—account中errorCode的删除
                    sinaAccountService.delErrorAccountByErrorCode(errorCode);
                }
            }
        }

    }
}
