package com.yekai.limiter.facade;

import com.yekai.limiter.facade.model.LimiterReqDTO;
import com.yekai.limiter.facade.model.LimiterResDTO;

/**
 * a、基于 lua + redis 实现业务流量控制
 * b、流量控制变种为商品库存模型及红包模型
 * <p>
 *     1、计算当前请求的key列表是否达到限流标准
 * </p>
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
public interface LimiterControlFacade {

    /**
     * 计算当前请求的key列表是否达到限流标准
     *
     * @param limiterReqDTO         限流请求参数
     * @return                      限流响应
     */
    LimiterResDTO limiterAcquire(LimiterReqDTO limiterReqDTO);

}