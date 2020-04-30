package com.yekai.limiter.facade.model;

import lombok.*;

import java.io.Serializable;

/**
 * 响应父类
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseResDTO implements Serializable {

    /**
     * 是否被限流
     *      true： 被限流
     *      false：未被限流
     */
    public boolean limitFlag;

    /**
     * 日志跟踪号
     */
    public String logNo;

    /**
     * 异常码
     */
    public String errorCode;

    /**
     * 异常原因
     */
    public String errorMsg;
}
