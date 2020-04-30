package com.yekai.limiter.service.tools;

import com.google.common.cache.*;
import com.yekai.limiter.common.utils.Combine;
import com.yekai.limiter.service.model.LimitCondition;
import com.yekai.limiter.service.model.LimitKeyBO;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 本地缓存处理
 *
 * <p>
 *     1、根据 key 获取缓存
 * </p>
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
public class LimitKeyCache {

    /**
     * guava cache 缓存实体
     */
    static LoadingCache<List<LimitKeyBO>, Set<String>> cache = CacheBuilder.newBuilder()
            // 缓存失效时间
            .expireAfterWrite(1, TimeUnit.DAYS)
            //最大缓存个数
            .maximumSize(100000)
            //开启统计信息开关
            .recordStats()
            .build(new CacheLoader<List<LimitKeyBO>, Set<String>>() {
                @Override
                public Set<String> load(List<LimitKeyBO> keys) {
                    return Combine.combination(keys).stream().map(cell -> new LimitCondition(cell).getKeyString()).collect(Collectors.toSet());
                }
            });


    /**
     * 根据 key 获取缓存
     * @param key       限流条件
     * @return          缓存结果
     */
    public static Set<String> getKeySet(List<LimitKeyBO> key) {
        return cache.getUnchecked(key);
    }
}