package com.yekai.limiter.common.utils;

import com.google.common.collect.Lists;
import com.yekai.limiter.service.model.LimitKeyBO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * 排列组合测试
 *
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
@Slf4j
public class CombineTest {

    /**
     * 排列组合算法测试
     */
    @Test
    public void testCombination(){
        List<LimitKeyBO> keys = Lists.newArrayList(new LimitKeyBO("BANK","ICBC"),
                new LimitKeyBO("TYPE","ORG"),
                new LimitKeyBO("SOURCE","TRADE"),
                new LimitKeyBO("CODE","123"));
        Set<List<LimitKeyBO>> target = Combine.combination(keys);

        target.forEach(a -> log.info(a.toString()));
    }
}
