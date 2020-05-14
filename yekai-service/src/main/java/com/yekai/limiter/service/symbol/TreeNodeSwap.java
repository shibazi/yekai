package com.yekai.limiter.service.symbol;


import com.yekai.limiter.common.exception.LimitException;
import com.yekai.limiter.common.exception.ResponseCodeEnum;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 左右子数交换
 *
 * <p>
 *      1、相同语义表达式归类
 * </p>
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
public class TreeNodeSwap {

    /**
     * 相同语义表达式归类
     * 左右节点有条件交换位置
     *      1、最底层节点点不交换
     *      2、根据叶子节运算优先级交换
     *      3、子节点运算优先级相同则比较后续节点值
     *
     * @param root      树
     */
    public static void swap1(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode tmp = root.leftChild;
        //最底层节点点不交换
        if(tmp != null && tmp.value.getCellType() == Cell.CellType.SYMBOL){
            //根据叶子节运算优先级交换
            if(((Symbol)root.leftChild.value).level() < ((Symbol)root.rightChild.value).level()){
                root.leftChild = root.rightChild;
                root.rightChild = tmp;
            }
            //子节点运算优先级相同则比较后续节点值
            if(((Symbol)root.leftChild.value).level() == ((Symbol)root.rightChild.value).level()){
                if(rightNode(root.rightChild).compareTo(rightNode(root.leftChild)) < 0){
                    root.leftChild = root.rightChild;
                    root.rightChild = tmp;
                }
            }
        }
        swap1(root.leftChild);
        swap1(root.rightChild);
    }

    /**
     * 当前树中最右侧第一个 VALUE 节点
     * @return  节点值
     */
    public static Cell rightNode(TreeNode head) {
        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        //和stack相关的全是获取最右节点
        Stack<TreeNode> stack = new Stack<>();
        queue.add(head);
        stack.add(head);
        int start = 0;
        int end = 1;
        while(!queue.isEmpty()) {
            current = queue.poll();
            start++;
            stack.add(current);
            if(current.leftChild != null) {
                queue.add(current.leftChild);
                stack.add(current.leftChild);
            }
            if(current.rightChild != null) {
                queue.add(current.rightChild);
                stack.add(current.rightChild);
            }
            if(start == end && !queue.isEmpty()) {
                start = 0;
                end = queue.size();
                Cell right = stack.peek().value;
                if(right.getCellType() == Cell.CellType.VALUE){
                    return right;
                }
            }
        }
        throw new LimitException(ResponseCodeEnum.ERR_000009);
    }
}