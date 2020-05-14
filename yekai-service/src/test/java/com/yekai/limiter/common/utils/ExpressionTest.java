package com.yekai.limiter.common.utils;

import com.yekai.limiter.service.symbol.Cell;
import com.yekai.limiter.service.symbol.Expression;
import com.yekai.limiter.service.symbol.TreeNode;
import com.yekai.limiter.service.symbol.TreePrinter;
import com.yekai.limiter.service.symbol.impl.AndSymbol;
import com.yekai.limiter.service.symbol.impl.EqualSymbol;
import com.yekai.limiter.service.symbol.impl.OrSymbol;
import org.junit.Test;

import java.util.Objects;

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

    @Test
    public void testExpression(){
        TreeNode root = express("a");
        TreePrinter.show(root);
        Expression.printMathExpression(root);
    }

    public static TreeNode express(String type) {
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

        if(Objects.equals("a",type)){
//          String key = "(TYPE==201||COED==TRADE)&&BANK==ICBC";
            return Expression.createBinaryTree(new Cell[]{y,e,f,g,h,i,j,k,x,d,a,b,c});
        }

        if(Objects.equals("b",type)){
//          String key = "BANK==ICBC&&(TYPE==201||COED==TRADE)";
            return Expression.createBinaryTree(new Cell[]{a,b,c,d,y,e,f,g,h,i,j,k,x});
        }

//          String key = "(COED==TRADE||TYPE==201)&&BANK==ICBC";
        return Expression.createBinaryTree(new Cell[]{y,i,j,k,h,e,f,g,x,d,a,b,c});

    }
}