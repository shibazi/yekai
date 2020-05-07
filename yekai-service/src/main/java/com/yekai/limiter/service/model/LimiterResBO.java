package com.yekai.limiter.service.model;

import com.yekai.limiter.facade.model.LimiterResDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 响应业务模型
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Getter
@Setter
@ToString
public class LimiterResBO {

    /**
     * 是否被限流
     *      true： 被限流
     *      false：未被限流
     */
    public boolean limitFlag;

    /**
     * 请求系统
     */
    public String requireSystem;

    /**
     * 限流类型
     *      PASS:限流未做任何处理
     *      VALIDATE：正常模式
     *      DEBUG：模拟计算（试跑）
     */
    public String limiterType;

    /**
     * 被限制的key
     */
    public String limitKey;

    /**
     * 限流的流量
     */
    public Integer permitsPreSecond;

    /**
     * 响应结果
     */
    public static LimiterResDTO getRes(LimiterResBO limiter,String logNo){
        LimiterResDTO limiterRes = new LimiterResDTO();
        limiterRes.setRequireSystem(limiter.requireSystem);
        limiterRes.setLimiterType(limiter.limiterType);
        limiterRes.setLimitKey(limiter.limitKey);
        limiterRes.setPermitsPreSecond(limiter.permitsPreSecond);
        limiterRes.setResult(limiter.limitFlag);
        limiterRes.setLogNo(logNo);
        return limiterRes;
    }


    /**
     * 响应结果
     *      未限流
     */
    public static LimiterResBO getRes(String requireSystem, String limiterType){
        LimiterResBO res = new LimiterResBO();
        res.setLimitFlag(false);
        res.setRequireSystem(requireSystem);
        res.setLimiterType(limiterType);
        return res;
    }

    /**
     * 响应结果
     *      被限流
     */
    public static LimiterResBO getRes(String requireSystem, String limiterType, String limitKey, Integer permitsPreSecond){
        LimiterResBO res = new LimiterResBO();
        res.setLimitFlag(true);
        res.setRequireSystem(requireSystem);
        res.setLimiterType(limiterType);
        res.setLimitKey(limitKey);
        res.setPermitsPreSecond(permitsPreSecond);
        return res;
    }
}