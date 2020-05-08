package com.yekai.limiter.service;

import com.google.common.collect.Sets;
import com.yekai.limiter.facade.LimiterControlFacade;
import com.yekai.limiter.facade.model.LimitKey;
import com.yekai.limiter.facade.model.LimiterReqDTO;
import com.yekai.limiter.facade.model.LimiterResDTO;
import org.junit.Test;

import java.util.UUID;

/**
 * 限流测试
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
public class LimiterControlServiceTest {

    /**
     * 限流服务
     */
    private LimiterControlFacade limiterControlFacade = new LimiterControlService();

    @Test
    public void testLimiterAcquire(){
        LimiterReqDTO limiterReqDTO = new LimiterReqDTO();
        limiterReqDTO.setRequireSystem("TRADE");
        limiterReqDTO.setLogId(UUID.randomUUID().toString());
        limiterReqDTO.setKeys(Sets.newHashSet(new LimitKey("BANK","ICBC"),new LimitKey("ORG","WECHAT")));
        LimiterResDTO res = limiterControlFacade.limiterAcquire(limiterReqDTO);
        System.out.println(res);
    }
}
