package com.yekai.limiter.service.model;

import com.yekai.limiter.facade.model.StockReqDTO;
import lombok.*;

/**
 * 库存模型
 *
 * @author : LZQ Date: 2020/05/07  Version: 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockBO {

    /**
     * 请求系统
     */
    public String requireSystem;

    /**
     * 产品编号
     */
    private String productId;

    /**
     * 数量
     */
    private Integer num;

    public static StockBO getStock(StockReqDTO stockReq){
        StockBO stock = new StockBO();
        stock.setRequireSystem(stockReq.getRequireSystem());
        stock.setProductId(stockReq.getProductId());
        stock.setNum(stockReq.getNum());
        return stock;
    }
}
