package com.yekai.limiter.service.symbol;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 运算符优先级
 *
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
@Getter
@AllArgsConstructor
public enum Level {

    /**
     * 括号
     */
    L1(1,"括号", Lists.newArrayList("()","[]")),

    /**
     * 大小关系
     */
    L7(7,"大小关系",Lists.newArrayList(">",">=","<","<=")),

    /**
     * 相等关系
     */
    L8(8,"相等关系",Lists.newArrayList("==","!=")),

    /**
     * 逻辑与
     */
    L12(12,"逻辑与",Lists.newArrayList("&&")),

    /**
     * 逻辑或
     */
    L13(13,"逻辑或",Lists.newArrayList("||"));

    /**
     * 优先级
     */
    private int level;

    /**
     * 描述
     */
    private String description;

    /**
     * 符号
     */
    private List<String> symbol;
}