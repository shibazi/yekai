package com.yekai.limiter.common.exception;

import lombok.Getter;

/**
 * 业务异常
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
@Getter
public class LimitException extends RuntimeException {

    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误描述
     */
    private final String desc;

    public LimitException(ResponseCodeEnum response) {
        super(response.getErrorDesc());
        this.code = response.getErrorCode();
        this.desc = response.getErrorDesc();
    }

    public LimitException(ResponseCodeEnum response, Throwable message) {
        super(response.getErrorDesc(), message);
        this.code = response.getErrorCode();
        this.desc = response.getErrorDesc();
    }

    public LimitException(ResponseCodeEnum response,String message) {
        super(message);
        this.code = response.getErrorCode();
        this.desc = response.getErrorDesc();
    }
}
