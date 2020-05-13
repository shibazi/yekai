package com.yekai.limiter.service.symbol.impl;

import com.yekai.limiter.service.biz.Matcher;
import com.yekai.limiter.service.symbol.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 前缀匹配
 *
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
@Slf4j
@SymbolEnum(level = Level.L8, symbol = "S",name = "前缀匹配")
public class StartWithSymbol extends Cell implements Symbol {


    public StartWithSymbol() {
        super(CellType.SYMBOL, StartWithSymbol.class.getAnnotation(SymbolEnum.class).symbol());
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
        return false;
    }
}