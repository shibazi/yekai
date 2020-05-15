package com.yekai.limiter.service.symbol;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 相同语义表达式归类
 *
 * <p>
 *     1、归类测试
 * </p>
 *
 * @author : LZQ Date: 2020/05/14  Version: 1.0
 */
@Slf4j
public class TreeNodeSwapTest {

    /**
     * 归类测试
     */
    @Test
    public void testSwap() {
        TreeNode a = ExpressionTest.express("a");
        TreePrinter.show(a);
        log.info(Expression.printMathExpression(a));
        TreeNodeSwap.swap1(a);
        log.info(Expression.printMathExpression(a));

//        TreeNode b = ExpressionTest.express("b");
////        TreePrinter.show(b);
//        Expression.printMathExpression(b);
//        TreeNodeSwap.swap1(b);
//        System.out.print("-->");
//        Expression.printMathExpression(b);
//        System.out.println();
//
//        TreeNode c = ExpressionTest.express("c");
////        TreePrinter.show(c);
//        Expression.printMathExpression(c);
//        TreeNodeSwap.swap1(c);
//        System.out.print("-->");
//        Expression.printMathExpression(c);
//        System.out.println();
    }


}
