package com.yekai.limiter.service.symbol.impl;

import com.yekai.limiter.service.biz.Matcher;
import com.yekai.limiter.service.symbol.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

/**
 * 相等操作
 *
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
@Slf4j
@SymbolEnum(level = Level.L8, symbol = "==",name = "相等")
public class EqualSymbol extends Cell implements Symbol {


    public EqualSymbol() {
        super(Cell.CellType.SYMBOL, EqualSymbol.class.getAnnotation(SymbolEnum.class).symbol());
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
        String key = node.rightChild.value.getValue();
        String value = node.leftChild.value.getValue();
        boolean res = Objects.equals(params.get(key), value);
        log.debug("id:{} execute {} params:{},{} res:{}",node.getId(),getName(),key,value,res);
        return res;
    }
}