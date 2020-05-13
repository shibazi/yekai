package com.yekai.limiter.service.symbol;

import lombok.Getter;
import lombok.Setter;

import static com.yekai.limiter.common.utils.ParamValidate.atomicInteger;

/**
 * 树
 *
 * <p>
 *     用于存储表达式
 * </p>
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
public class TreeNode {

    public TreeNode() {
        id = atomicInteger.getAndAdd(1);
    }

    /**
     * 节点 id
     */
    @Getter
    private int id;

    /**
     * 左节点
     */
    @Getter
    @Setter
    public TreeNode leftChild;

    /**
     * 右节点
     */
    @Getter
    @Setter
    public TreeNode rightChild;

    /**
     * 值
     */
    @Getter
    @Setter
    public Cell value;

    @Override
    public String toString() {
        return value.toString();
    }
}
