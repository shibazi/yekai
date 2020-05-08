package com.yekai.limiter.common.exception;

import com.yekai.limiter.facade.model.BaseReqDTO;
import com.yekai.limiter.facade.model.LimiterResDTO;

import static com.yekai.limiter.common.exception.ResponseCodeEnum.ERR_000005;

/**
 * 异常处理
 *
 * <p>
 *     1、处理异常
 * </p>
 *
 * @author : LZQ Date: 2020/04/29  Version: 1.0
 */
public class ExceptionUtil {

    /**
     * 统一异常处理
     *
     * @param err 异常
     * @return 外部响应对象
     */
    public static <T extends BaseReqDTO> LimiterResDTO doExceptionService(Throwable err, T reqDTO) {
        if (err instanceof LimitException) {
            return  new LimiterResDTO(false,reqDTO.logId,((LimitException) err).getCode(),((LimitException) err).getDesc());
        }
        return new LimiterResDTO(false,reqDTO.logId,ERR_000005.getErrorCode(),ERR_000005.getErrorDesc());
    }

}