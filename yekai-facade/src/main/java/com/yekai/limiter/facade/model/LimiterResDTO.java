package com.yekai.limiter.facade.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 限流调用响应
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class LimiterResDTO extends BaseResDTO {

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
     * 构造方法
     */
    public LimiterResDTO(boolean limitFlag, String logNo, String errorCode, String errorMsg) {
        super(limitFlag, logNo, errorCode, errorMsg);
    }
}