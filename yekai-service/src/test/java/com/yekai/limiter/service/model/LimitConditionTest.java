package com.yekai.limiter.service.model;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * 限流条件 单元测试
 *
 * <p>
 *     1、key值排序后拼接的字符串
 * </p>
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
public class LimitConditionTest {

    /**
     * key值排序后拼接的字符串
     */
    @Test
    public void testGetKeyString(){
        List<LimitKeyBO> keys = Lists.newArrayList(new LimitKeyBO("ABC","5"),new LimitKeyBO("ICBC","4"),new LimitKeyBO("CCB","2"));
        LimitCondition condition = new LimitCondition(keys,10);
        System.out.println(condition.getKeyString());
    }
}