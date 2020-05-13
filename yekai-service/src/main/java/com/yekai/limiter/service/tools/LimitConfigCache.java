package com.yekai.limiter.service.tools;

import com.google.common.collect.Maps;
import com.yekai.limiter.common.exception.LimitException;
import com.yekai.limiter.common.exception.ResponseCodeEnum;
import com.yekai.limiter.manager.model.LimitInfoDO;
import com.yekai.limiter.service.symbol.Cell;
import com.yekai.limiter.service.symbol.Expression;
import com.yekai.limiter.service.symbol.TreeNode;
import com.yekai.limiter.service.symbol.impl.AndSymbol;
import com.yekai.limiter.service.symbol.impl.EqualSymbol;
import com.yekai.limiter.service.symbol.impl.OrSymbol;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;

import static com.yekai.limiter.service.symbol.Cell.CellType.*;

/**
 * 限流配置缓存
 *
 * <p>
 *     1、加载配置项
 * </p>
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
@Slf4j
public class LimitConfigCache {

    /**
     * 最高优先级的限流配置集合
     */
    public static Map<LimitInfoDO,TreeNode> treeNodes = Maps.newHashMap();

    static {
        try {
            //todo 初始化及数据库操作
            treeNodes.put(getLimitConfig(),getLimit());
        }catch (Exception e){
            log.error("限流规则加载失败：",e);
            throw new LimitException(ResponseCodeEnum.ERR_000003,e);
        }
    }

    /**
     * 临时方法
     *      //todo
     */
    private static TreeNode getLimit(){
        Cell a = new Cell(VALUE,"BANK");
        Cell b = new EqualSymbol();
        Cell c = new Cell(VALUE,"ICBC");

        Cell d = new AndSymbol();

        Cell y = new Cell(L_BOX,"(");

        Cell e = new Cell(VALUE,"TYPE");
        Cell f = new EqualSymbol();
        Cell g = new Cell(VALUE,"201");

        Cell h = new OrSymbol();

        Cell i = new Cell(VALUE,"CODE");
        Cell j = new EqualSymbol();
        Cell k = new Cell(VALUE,"TRADE");

        Cell x = new Cell(R_BOX,")");

        return Expression.createBinaryTree(new Cell[]{a,b,c,d,y,e,f,g,h,i,j,k,x});
    }
    /**
     * 临时方法
     *      //todo
     */
    private static LimitInfoDO getLimitConfig(){
        LimitInfoDO limitInfo = new LimitInfoDO();
        limitInfo.setKey("BANK==ICBC&&(TYPE==201||CODE==TRADE)");
        limitInfo.setLevel(1);
        limitInfo.setValue(1);
        return limitInfo;
    }
}