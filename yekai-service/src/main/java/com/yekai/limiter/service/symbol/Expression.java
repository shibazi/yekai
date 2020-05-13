package com.yekai.limiter.service.symbol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.yekai.limiter.service.symbol.Cell.CellType.*;

/**
 * 表达式
 *
 * <p>
 *      解析表达式
 * </p>
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
public class Expression {

    /**
     *      * 将算术表达式转化成二叉树
     *      * 
     *      * @param expression
     *      *            为了方便，使用字符串数组来存储表达式
     *      * @return 二叉树的根节点
     *     
     */
    public static TreeNode createBinaryTree(Cell[] expression) {
    // 存储操作数的栈
        Stack<Cell> opStack = new Stack<>();
    // 存储转换后的逆波兰式的队列
        Queue<Cell> reversePolish = new LinkedList<>();
        for (Cell cell : expression) {
            // 如果是数字
            switch (cell.getCellType()) {
                case VALUE:
                    reversePolish.offer(cell);
                    break;
                //是左括号直接入栈
                case L_BOX:
                    opStack.push(cell);
                    break;
                case R_BOX:
                    // 把离上一个“（”之间的操作符全部弹出来放入逆波兰式的队列中
                    while (!opStack.isEmpty()) {
                        Cell op = opStack.peek();
                        if (op.getCellType() == L_BOX) {
                            opStack.pop();
                            break;
                        } else {
                            reversePolish.offer(opStack.pop());
                        }
                    }
                    break;
                case SYMBOL:
                    while (!opStack.isEmpty()) {
                        // 如果栈顶元素为"("直接入栈
                        if (opStack.peek().getCellType() == L_BOX) {
                            opStack.push(cell);
                            break;
                            //如果栈顶元素优先级大于s
                        } else if (((Symbol)opStack.peek()).level()<((Symbol)cell).level()) {
                            reversePolish.offer(opStack.pop());
                        } else {
                            opStack.push(cell);
                            break;
                        }
                    }
                    // 如果栈为空，直接入栈
                    if (opStack.isEmpty()) {
                        opStack.push(cell);
                    }
                    break;
                default:
                    System.out.println("error");
            }
        }
        // 将剩余的操作符入队
        while (!opStack.isEmpty()) {
            reversePolish.offer(opStack.pop());
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        // 将逆波兰式转化成二叉树
        while (!reversePolish.isEmpty()) {
            Cell c = reversePolish.poll();
        // 以当前的元素的值新建一个节点
            TreeNode node = new TreeNode();
            node.value = c;
        // 如果是数字
            if (c.getCellType() != VALUE) {
                //从栈里弹出两个节点作为当前节点的左右子节点
                node.leftChild = nodeStack.pop();
                node.rightChild = nodeStack.pop();
            }
            nodeStack.push(node);
        }
        return nodeStack.pop();
    }

    /**
     *      * 打印出还原的算术表达式
     *      * @param root
     *     
     */
    public static void printMathExpression(TreeNode root) {
        if (root != null) {
            if (Cell.CellType.VALUE != root.value.getCellType()) {
                System.out.print("(");
            }
            printMathExpression(root.rightChild);
            System.out.print(root.value.getValue());
            printMathExpression(root.leftChild);

            if (Cell.CellType.VALUE != root.value.getCellType()){
                System.out.print(")");
            }
        }
    }
}