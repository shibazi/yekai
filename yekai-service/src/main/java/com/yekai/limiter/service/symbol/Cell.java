package com.yekai.limiter.service.symbol;

import lombok.*;

/**
 * 单元
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
@Getter
@Setter
@AllArgsConstructor
public class Cell {

    /**
     * 节点类型
     */
     private CellType cellType;

    /**
     * 节点值
     */
    private String value;

    @Override
    public String toString() {
        return value;
    }

    /**
     * 节点类型
     */
     public enum CellType {

        /**
         * 值
         */
        VALUE,

        /**
         * 运算符
         */
        SYMBOL,

        /**
         * 左括号
         */
        L_BOX,

        /**
         * 右括号
         */
        R_BOX
    }
}