package com.yekai.limiter.service;

import com.yekai.limiter.common.exception.ExceptionUtil;
import com.yekai.limiter.common.utils.ParamValidate;
import com.yekai.limiter.facade.StockControlFacade;
import com.yekai.limiter.facade.model.BaseResDTO;
import com.yekai.limiter.facade.model.StockReqDTO;
import com.yekai.limiter.service.biz.StockBiz;
import com.yekai.limiter.service.model.StockBO;
import com.yekai.limiter.service.model.StockResBO;
import lombok.extern.slf4j.Slf4j;

/**
 * 商品库存管理
 * 高并发下库存扣减解决方案(redis 问题可用双集群)
 *
 * <p>
 *     1、增加库存
 *     2、减少库存
 *     3、删除库存
 * </p>
 *
 * @author : LZQ Date: 2020/05/07  Version: 1.0
 */
@Slf4j
public class StockControlService implements StockControlFacade {

    /**
     * 增加库存
     *      1、初始化库存
     *      2、退库存
     *
     * @param stockReqDTO 设置库存参数
     * @return            调用结果
     */
    @Override
    public BaseResDTO incrStock(StockReqDTO stockReqDTO) {
        return null;
    }

    /**
     * 减少库存
     *      1、去库存
     *
     * @param stockReqDTO 设置库存参数
     * @return            调用结果
     */
    @Override
    public BaseResDTO decrStock(StockReqDTO stockReqDTO) {
        long start = System.currentTimeMillis();
        BaseResDTO res = null;
        try{
            log.info("start invoke decrStock params{}",stockReqDTO);
            ParamValidate.validateObject(stockReqDTO);

            StockResBO stockRes = StockBiz.get().process(StockBO.getStock(stockReqDTO));
            res = stockRes.convert(stockRes,stockReqDTO.logId);
        }catch (Exception e){
            log.error("error invoke decrStock exception:",e);
            res = ExceptionUtil.doExceptionService(e,stockReqDTO);
        } finally {
            log.info("finish invoke decrStock cost:{} result:{}",System.currentTimeMillis() - start,res);
        }
        return res;
    }

    /**
     * 删除商品库存
     */
    @Override
    public void delStock() {

    }
}