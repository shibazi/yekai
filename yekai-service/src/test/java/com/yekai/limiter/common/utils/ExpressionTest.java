package com.yekai.limiter.common.utils;

import com.yekai.limiter.service.symbol.Cell;
import com.yekai.limiter.service.symbol.Expression;
import com.yekai.limiter.service.symbol.TreeNode;
import com.yekai.limiter.service.symbol.TreePrinter;
import com.yekai.limiter.service.symbol.impl.AndSymbol;
import com.yekai.limiter.service.symbol.impl.EqualSymbol;
import com.yekai.limiter.service.symbol.impl.OrSymbol;

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
public class ExpressionTest {
//
//    /**
//     *      * 将算术表达式转化成二叉树
//     *      * 
//     *      * @param expression
//     *      *            为了方便，使用字符串数组来存储表达式
//     *      * @return 二叉树的根节点
//     *     
//     */
//    public static TreeNode createBinaryTree(String[] expression) {
//    // 存储操作数的栈
//        Stack<String> opStack = new Stack<>();
//    // 存储转换后的逆波兰式的队列
//        Queue<String> reversePolish = new LinkedList<>();
//        for (String s : expression) {
//            // 如果是数字
//            if (isDigit(s)) {
//                reversePolish.offer(s);
//            // 如果是操作符    
//            } else if (isOperator(s)) {
//            //是左括号直接入栈
//                if ("(".equals(s)) {
//                    opStack.push(s);
//                    // 如果是右括号 
//                } else if (")".equals(s)) {
//                    // 把离上一个“（”之间的操作符全部弹出来放入逆波兰式的队列中
//                    while (!opStack.isEmpty()) {
//                        String op = opStack.peek();
//                        if (op.equals("(")) {
//                            opStack.pop();
//                            break;
//                        } else {
//                            reversePolish.offer(opStack.pop());
//                        }
//                    }
//                } else {
//                    while (!opStack.isEmpty()) {
//                        // 如果栈顶元素为"("直接入栈
//                        if ("(".equals(opStack.peek())) {
//                            opStack.push(s);
//                            break;
//                            //如果栈顶元素优先级大于s
//                        } else if (isGreat(opStack.peek(), s)) {
//                            reversePolish.offer(opStack.pop());
////                        } else if (isGreat(s, opStack.peek())) {
//                        } else{
//                            opStack.push(s);
//                            break;
//                        }
//                    }
//                    // 如果栈为空，直接入栈
//                    if (opStack.isEmpty())
//                        opStack.push(s);
//                }
//            }
//        }
//        // 将剩余的操作符入队
//        while (!opStack.isEmpty()) {
//            reversePolish.offer(opStack.pop());
//        }
//        Stack<TreeNode> nodeStack = new Stack<>();
//        // 将逆波兰式转化成二叉树
//        while (!reversePolish.isEmpty()) {
//            String s = reversePolish.poll();
//        // 以当前的元素的值新建一个节点
//            TreeNode node = new TreeNode();
//            node.setValue(new Cell(Cell.CellType.VALUE,s));
//        // 如果是数字
//            if (isDigit(s)) {
//                nodeStack.push(node);
//                // 如果是操作符
////            } else if (isOperator(s)) {
//            }else {
//                //从栈里弹出两个节点作为当前节点的左右子节点
//                node.leftChild = nodeStack.pop();
//                node.rightChild = nodeStack.pop();
//                // 入栈
//                nodeStack.push(node);
//            }
//        }
//        return nodeStack.pop();
//    }
//
//    /**
//     *   * 判断是否为运算符（暂时只判断四则运算的运算符）
//     *   * 
//     *   * @param s
//     *      * @return
//     *     
//     */
//    static boolean isOperator(String s) {
//
//        return "(".equals(s) || ")".equals(s) || "+".equals(s) || "-".equals(s)
//                || "*".equals(s) || "/".equals(s);
//    }
//
//    /**
//     *      * 判断是否为数字
//     *      * 
//     *      * @param s
//     *      * @return
//     *     
//     */
//    static boolean isDigit(String s) {
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if (!Character.isDigit(s.charAt(i)))
//
//                return false;
//        }
//
//        return true;
//    }
//
//    /**
//     *      * 判断op1和op2的优先级，如果op1>op2，返回true，如果op1<=op2，返回false
//     *      * 
//     *      * @param op1
//     *      * @param op2
//     *      * @return
//     *     
//     */
//    static boolean isGreat(String op1, String op2) {
//
//        return getPriority(op1) > getPriority(op2);
//    }
//
//    /**
//     *      * 获取运算符的优先级
//     *      * 
//     *      * @param op
//     *      * @return
//     *     
//     */
//    static int getPriority(String op) {
//
//        if ("+".equals(op) || "-".equals(op))
//
//            return 1;
//
//        else if ("*".equals(op) || "/".equals(op))
//
//            return 2;
//
//        else
//
//            throw new IllegalArgumentException("Unsupported operator!");
//    }
//
//    /**
//     *      * 打印出还原的算术表达式
//     *      * @param root
//     *     
//     */
//    static void printMathExpression(TreeNode root) {
//
//        if (root != null) {
//            if (isOperator(root.value.getValue()))
//                System.out.print("(");
//            printMathExpression(root.rightChild);
//            System.out.print(root.value);
//            printMathExpression(root.leftChild);
//            if (isOperator(root.value.getValue()))
//                System.out.print(")");
//        }
//    }
//
//    public static void main(String[] args) {
//        String s = "(1+2)*(5+3)";
//        TreeNode root = createBinaryTree(new String[]{"(", "1", "+", "2", ")", "*", "(", "5", "-", "3", ")"});
//        TreePrinter.show(root);
//        printMathExpression(root);
//    }




    public static void main(String[] args) {
        Cell a = new Cell(VALUE,"BANK");
        Cell b = new EqualSymbol();
        Cell c = new Cell(VALUE,"ICBC");

        Cell d = new AndSymbol();

        Cell y = new Cell(L_BOX,"(");

        Cell e = new Cell(VALUE,"TYPE");
        Cell f = new EqualSymbol();
        Cell g = new Cell(VALUE,"201");

        Cell h = new OrSymbol();

        Cell i = new Cell(VALUE,"COED");
        Cell j = new EqualSymbol();
        Cell k = new Cell(VALUE,"TRADE");

        Cell x = new Cell(R_BOX,")");

        String key = "BANK==ICBC&&(TYPE==201||COED==TRADE)";

        TreeNode root = Expression.createBinaryTree(new Cell[]{a,b,c,d,y,e,f,g,h,i,j,k,x});
        TreePrinter.show(root);
        Expression.printMathExpression(root);
    }
}
