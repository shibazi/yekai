package com.yekai.limiter.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 异常码
 *
 * @author LZQ
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum  {

    /**
     * 二叉树规则有误
     */
    ERR_000009("ERR_000009", "二叉树规则有误"),

    /**
     * 无效产品
     */
    ERR_000008("ERR_000008", "无效产品"),

    /**
     * 库存不足
     */
    ERR_000007("ERR_000007", "库存不足"),

    /**
     * 请初始化脚本执行器
     */
    ERR_000006("ERR_000006", "请初始化脚本执行器"),

    /**
     * 系统异常
     */
    ERR_000005("ERR_000005", "系统异常"),

    /**
     * 限流脚本执行异常
     */
    ERR_000004("ERR_000004", "限流脚本执行异常"),

    /**
     * 限流规则加载失败
     */
    ERR_000003("ERR_000003", "限流规则加载失败"),

    /**
     * redis初始化异常
     */
    ERR_000002("ERR_000002", "redis 初始化异常"),

    /**
     * 参数校验不通过
     */
    ERR_000001("ERR_000001", "参数校验不通过");

    /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    @Setter
    private String errorDesc;
}