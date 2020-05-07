package com.yekai.limiter.service.model;

import com.yekai.limiter.common.exception.ResponseCodeEnum;
import com.yekai.limiter.facade.model.BaseResDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * 响应业务模型
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StockResBO {

    /**
     * 处理结果
     *
     *      true： 被限流
     *      false：未被限流
     */
    public boolean result;

    /**
     * 请求系统
     */
    public String requireSystem;

    /**
     * 异常码
     */
    public String errorCode;

    /**
     * 异常原因
     */
    public String errorMsg;

    public static StockResBO getStock(String result,String requireSystem){
        StockResBO stockRes = new StockResBO();
        stockRes.setRequireSystem(requireSystem);
        if(Objects.equals(result,"OK")){
            stockRes.setResult(true);
            return stockRes;
        }
        stockRes.setResult(false);
        if(Objects.equals(result,"F")){
            stockRes.setErrorCode(ResponseCodeEnum.ERR_000007.getErrorCode());
            stockRes.setErrorMsg(ResponseCodeEnum.ERR_000007.getErrorDesc());
        }
        if(Objects.equals(result,"E")){
            stockRes.setErrorCode(ResponseCodeEnum.ERR_000008.getErrorCode());
            stockRes.setErrorMsg(ResponseCodeEnum.ERR_000008.getErrorDesc());
        }
        return stockRes;
    }

    /**
     * 参数转换
     */
    public BaseResDTO convert(StockResBO stockRes,String logId) {
        BaseResDTO res = new BaseResDTO();
        res.setResult(stockRes.result);
        res.setErrorCode(stockRes.errorCode);
        res.setErrorMsg(stockRes.errorMsg);
        res.setLogNo(logId);
        return res;
    }
}