package com.yekai.limiter.service.biz;

import com.google.common.collect.ImmutableMap;
import com.yekai.limiter.manager.model.LimitInfoDO;
import com.yekai.limiter.service.model.LimiterBO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.List;

/**
 * 匹配器测试
 *
 *
 * @author : LZQ Date: 2020/05/13  Version: 1.0
 */
@Slf4j
public class MatcherTest {

    /**
     * 匹配测试
     */
    @Test
    public void testMatch(){
        List<LimitInfoDO> matched =Matcher.get().match(new LimiterBO("TRADE", ImmutableMap.of("BANK","ICBC","CODE","TRADE")));
        log.info(matched.toString());
    }
}