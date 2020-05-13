package com.yekai.limiter.service.symbol;

import com.yekai.limiter.service.biz.Matcher;
import java.util.Map;

/**
 * 运算操作
 *
 * <p>
 *     1、优先级
 *     2、节点类型
 *     3、节点值
 *     4、节点名称
 *     5、运算操作
 * </p>
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
public interface Symbol {

    /**
     * 优先级
     *
     * @return 优先级
     */
    default int level(){
        return this.getClass().getAnnotation(SymbolEnum.class).level().getLevel();
    }


    /**
     * 节点名称
     *
     * @return 节点名称
     */
    default String getName(){
        return this.getClass().getAnnotation(SymbolEnum.class).name();
    }

    /**
     * 运算操作
     *
     * @param params     限流参数
     * @param node       配置节点
     * @param matcher    匹配器
     * @return          运算操作
     */
    boolean operating(Map<String,String> params, TreeNode node, Matcher matcher);

}