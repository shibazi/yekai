package com.yekai.limiter.facade;

import com.yekai.limiter.facade.model.BaseResDTO;
import com.yekai.limiter.facade.model.StockReqDTO;

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
public interface StockControlFacade {

    /**
     * 增加库存
     *      1、初始化库存
     *      2、退库存
     *
     * @param stockReqDTO       设置库存参数
     * @return                  调用结果
     */
    BaseResDTO incrStock(StockReqDTO stockReqDTO);

    /**
     * 减少库存
     *      1、去库存
     *
     * @param stockReqDTO       设置库存参数
     * @return                  调用结果
     */
    BaseResDTO decrStock(StockReqDTO stockReqDTO);

    /**
     * 删除商品库存
     */
    void delStock();
}