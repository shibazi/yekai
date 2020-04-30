package com.yekai.limiter.service.model;

import com.yekai.limiter.facade.model.LimiterReqDTO;
import lombok.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 业务处理模型
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LimiterBO {

    /**
     * 请求系统
     */
    public String requireSystem;

    /**
     * 需要被计数的参数列表
     */
    public Set<LimitKeyBO> keys;

    /**
     * 构造方法
     *
     * @param limiterReqDTO     请求参数
     */
    public static LimiterBO getLimiter(LimiterReqDTO limiterReqDTO) {
        Set<LimitKeyBO> keyList = limiterReqDTO.getKeys().stream()
                                                .map(key -> new LimitKeyBO(key.getKey(), key.getValue()))
                                                .collect(Collectors.toSet());

        return new LimiterBO(limiterReqDTO.getRequireSystem(),keyList);
    }
}