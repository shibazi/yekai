package com.yekai.limiter.service;

import com.yekai.limiter.common.exception.ExceptionUtil;
import com.yekai.limiter.common.utils.ParamValidate;
import com.yekai.limiter.facade.LimiterControlFacade;
import com.yekai.limiter.facade.model.LimiterReqDTO;
import com.yekai.limiter.facade.model.LimiterResDTO;
import com.yekai.limiter.service.biz.LimiterBiz;
import com.yekai.limiter.service.model.LimiterBO;
import com.yekai.limiter.service.model.LimiterResBO;
import lombok.extern.slf4j.Slf4j;

/**
 * 限流处理实现
 *
 * <p>
 *     1、计算当前请求的key列表是否达到限流标准
 * </p>
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Slf4j
public class LimiterControlService implements LimiterControlFacade {

    /**
     * 计算当前请求的key列表是否达到限流标准
     *
     * @param limiterReqDTO 限流请求参数
     * @return 限流响应
     */
    @Override
    public LimiterResDTO limiterAcquire(LimiterReqDTO limiterReqDTO) {
        long start = System.currentTimeMillis();
        LimiterResDTO res = null;
        try{
            log.info("start invoke limiterAcquire params{}",limiterReqDTO);
            ParamValidate.validateObject(limiterReqDTO);
            res = LimiterResBO.getRes(LimiterBiz.get().limit(LimiterBO.getLimiter(limiterReqDTO)),limiterReqDTO.logId);
        }catch (Exception e){
            log.error("error invoke limiterAcquire exception:",e);
            res = ExceptionUtil.doExceptionService(e,limiterReqDTO);
        } finally {
            log.info("finish invoke limiterAcquire cost:{} result:{}",System.currentTimeMillis() - start,res);
        }
        return res;
    }
}