package com.yekai.limiter.service.biz;

import com.google.common.collect.Lists;
import com.yekai.limiter.service.model.StockBO;
import com.yekai.limiter.service.model.StockResBO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 库存服务
 *
 * <p>
 *     1、操作库存数
 * </p>
 *
 * @author : LZQ Date: 2020/05/07  Version: 1.0
 */
@Slf4j
public class StockBiz {

    /**
     * 私有构造方法
     */
    private StockBiz() {}

    /**
     * 单例
     */
    private static final StockBiz BIZ = new StockBiz() ;

    /**
     * 获取实例
     *
     * @return      业务处理实例
     */
    public static StockBiz get(){
        return BIZ;
    }

    /**
     * 操作库存数
     *
     * @param stock 库存请求参数
     */
    public StockResBO process(StockBO stock){
        List<String> keys = Lists.newArrayList(stock.getProductId());
        List<String> values = Lists.newArrayList(String.valueOf(stock.getNum()));

        String result = StockExecutor.getExecutor().execute(keys,values);
        log.debug("result:{}",result);
        return StockResBO.getStock(result,stock.requireSystem);
    }

}