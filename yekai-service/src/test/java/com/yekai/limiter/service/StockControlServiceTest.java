package com.yekai.limiter.service;

import com.yekai.limiter.facade.StockControlFacade;
import com.yekai.limiter.facade.model.BaseResDTO;
import com.yekai.limiter.facade.model.StockReqDTO;
import org.junit.Test;

import java.util.UUID;

/**
 * 库存验证
 *
 * <p>
 *     1、减库存验证
 * </p>
 *
 * @author : LZQ Date: 2020/05/07  Version: 1.0
 */
public class StockControlServiceTest {

    private StockControlFacade stockControlFacade = new StockControlService();

    /**
     * 减库存验证
     */
    @Test
    public void testDecrStock(){
        StockReqDTO stockReqDTO = new StockReqDTO();
        stockReqDTO.setRequireSystem("TRADE");
        stockReqDTO.setNum(2);
        stockReqDTO.setProductId("00001");
        stockReqDTO.setLogId(String.valueOf(UUID.randomUUID()));
        BaseResDTO res = stockControlFacade.decrStock(stockReqDTO);
        System.out.println(res);
    }
}