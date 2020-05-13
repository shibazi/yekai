package com.yekai.limiter.service.symbol.impl;

import com.yekai.limiter.service.biz.Matcher;
import com.yekai.limiter.service.symbol.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 并且操作
 *
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
@Slf4j
@SymbolEnum(level = Level.L12, symbol = "&&",name = "逻辑与")
public class AndSymbol extends Cell implements Symbol {

    public AndSymbol() {
        super(CellType.SYMBOL, AndSymbol.class.getAnnotation(SymbolEnum.class).symbol());
    }

    /**
     * 运算操作
     *
     * @param params     限流参数
     * @param node       配置节点
     * @param matcher    匹配器
     * @return           运算操作
     */
    @Override
    public boolean operating(Map<String,String> params, TreeNode node, Matcher matcher) {
        log.debug("id:{} execute {} params:{},{}",node.getId(),getName(),node.rightChild,node.leftChild);
        boolean res = matcher.iterator(params,node.rightChild) && matcher.iterator(params,node.leftChild) ;
        log.debug("id:{} execute {} res:{}",node.getId(),getName(),res);
        return res;
    }
}