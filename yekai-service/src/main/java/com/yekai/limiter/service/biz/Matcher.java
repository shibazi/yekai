package com.yekai.limiter.service.biz;

import com.google.common.collect.Lists;
import com.yekai.limiter.manager.model.LimitInfoDO;
import com.yekai.limiter.service.model.LimiterBO;
import com.yekai.limiter.service.symbol.Symbol;
import com.yekai.limiter.service.symbol.TreeNode;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import static com.yekai.limiter.service.symbol.Cell.CellType.SYMBOL;
import static com.yekai.limiter.service.tools.LimitConfigCache.treeNodes;

/**
 * 匹配器
 *
 * <p>
 *     1、获取所有规则匹配
 *     2、逐条匹配规则
 * </p>
 *
 * @author : LZQ Date: 2020/05/12  Version: 1.0
 */
@Slf4j
public class Matcher {

    /**
     * 私有构造方法
     */
    private Matcher() {}

    /**
     * 单例
     */
    private static final Matcher BIZ = new Matcher() ;

    /**
     * 获取实例
     *
     * @return      业务处理实例
     */
    public static Matcher get(){
        return BIZ;
    }

    /**
     * 获取所有规则匹配
     */
    public List<LimitInfoDO> match(LimiterBO limiterReq){
        List<LimitInfoDO> matched = Lists.newArrayList();
        long count = treeNodes.entrySet().stream()
                .map(entry -> iterator(limiterReq.keys,entry.getValue()) ? matched.add(entry.getKey()) : null)
                .filter(Objects::nonNull)
                .count();
        log.debug("匹配条数：{}",count);
        return matched;
    }

    /**
     * 逐条匹配规则
     */
    public boolean iterator(Map<String,String> params, TreeNode node){
        if(node == null || node.value.getCellType() != SYMBOL){
            return false;
        }
        return ((Symbol)node.getValue()).operating(params,node,this);
    }
}
