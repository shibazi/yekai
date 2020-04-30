package com.yekai.limiter.service.biz;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.yekai.limiter.service.model.*;
import com.yekai.limiter.service.tools.LimitKeyCache;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Set;

import static com.yekai.limiter.service.model.LimitTypeEnum.VALIDATE;
import static com.yekai.limiter.service.tools.LimitConfigCache.limitConfigMap;

/**
 * 限流业务处理
 *
 * <p>
 *     1、限流处理流程
 * </p>
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Slf4j
public class LimiterBiz {

    /**
     * 私有构造方法
     */
    private LimiterBiz() {}

    /**
     * 单例
     */
    private static final LimiterBiz BIZ = new LimiterBiz() ;

    /**
     * 默认限流类型：正常模式
     *          //todo 待更新
     */
    public LimitTypeEnum limitType = VALIDATE;

    /**
     * lua 脚本执行结果
     */
    private static final String OK = "OK";

    /**
     * 获取实例
     *
     * @return      业务处理实例
     */
    public static LimiterBiz get(){
        return BIZ;
    }

    /**
     * 限流处理流程
     *          1、限流模式处理
     *          2、限流前key处理
     *          3、流量计算
     *
     *
     * @param limiterReq      请求参数
     * @return                限流结果
     */
    public LimiterResBO limit(LimiterBO limiterReq){
        LimiterResBO res = LimiterResBO.getRes(limiterReq.requireSystem,limitType.name());
        switch (limitType){
            case VALIDATE :
                return process(limiterReq);
            case DEBUG:
                process(limiterReq);
                return res;
            case PASS:
                return res;
            default:
                log.error("limitType error:{}",limitType);
        }
        return null;
    }

    /**
     * 匹配有效的限流规则
     *          1、查找缓存key的排列组合
     *          2、匹配命中的规则
     *
     * @param limiterReq        请求参数
     * @return                  有效规则
     */
    public List<String>[] beforeProcess(LimiterBO limiterReq){
        Set<String> combineSet = LimitKeyCache.getKeySet(Lists.newArrayList(limiterReq.getKeys()));

        List<String> keys = Lists.newArrayList(Sets.intersection(combineSet, limitConfigMap.keySet()));
        List<String> values = Lists.newArrayList();
        keys.forEach(key ->values.add(limitConfigMap.get(key)));
        return new List[]{keys, values};
    }

    /**
     * 限流处理
     */
    public LimiterResBO process(LimiterBO limiterReq){
        List<String>[] effectiveConfig = beforeProcess(limiterReq);
        if(effectiveConfig[0].size() == 0){
            return LimiterResBO.getRes(limiterReq.requireSystem,limitType.name());
        }
        return afterProcess(SentinelLuaExecutor.getExecutor().execute(effectiveConfig[0],effectiveConfig[1]),limiterReq);
    }

    /**
     * 限流结果处理
     */
    public LimiterResBO afterProcess(String result,LimiterBO limiterReq){
        if(OK.equals(result)){
            return LimiterResBO.getRes(limiterReq.requireSystem,limitType.name());
        }
        Integer permitsPreSecond = Integer.parseInt(limitConfigMap.get(result));
        return LimiterResBO.getRes(limiterReq.requireSystem,limitType.name(),result,permitsPreSecond);
    }
}