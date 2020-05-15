package com.yekai.limiter.service;

import com.google.common.collect.ImmutableMap;
import com.yekai.limiter.facade.LimiterControlFacade;
import com.yekai.limiter.facade.model.LimiterReqDTO;
import com.yekai.limiter.facade.model.LimiterResDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.UUID;

/**
 * 限流测试
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
@Slf4j
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
        limiterReqDTO.setParams(ImmutableMap.of("BANK","ICBC","CODE","TRADE"));
        LimiterResDTO res = limiterControlFacade.limiterAcquire(limiterReqDTO);
        log.info(res.toString());
    }
}
