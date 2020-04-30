package com.yekai.limiter.service.model;

import lombok.Getter;

/**
 * 限流类型
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Getter
public enum LimitTypeEnum {

    /**
     * 不做任何处理
     */
    PASS,

    /**
     * 正常模式
     */
    VALIDATE,

    /**
     * 模拟计算（试跑）
     */
    DEBUG
}
