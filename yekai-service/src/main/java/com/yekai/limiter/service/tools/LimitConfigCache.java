package com.yekai.limiter.service.tools;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yekai.limiter.common.exception.LimitException;
import com.yekai.limiter.common.exception.ResponseCodeEnum;
import com.yekai.limiter.manager.model.LimitInfoDO;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public static Map<String,String> limitConfigMap = Maps.newHashMap();

    /**
     * 加载配置项
     *      先分组，后找优先级最高的配置项
     */
    static {
        try {
            //todo 初始化及数据库操作
            List<LimitInfoDO> infos = Lists.newArrayList(getLimit());

            infos.stream()
                    .collect(Collectors.groupingBy(LimitInfoDO::getKey))
                    .forEach((key, value) -> limitConfigMap.put(key,
                            String.valueOf(value.stream().sorted().findFirst().get().getValue())));
        }catch (Exception e){
            log.error("限流规则加载失败：",e);
            throw new LimitException(ResponseCodeEnum.ERR_000003,e);
        }
    }

    /**
     * 临时方法
     *      //todo
     */
    private static LimitInfoDO getLimit(){
        LimitInfoDO limitInfo = new LimitInfoDO();
        limitInfo.setKey("BANK=ICBC");
        limitInfo.setLevel(1);
        limitInfo.setValue(0);
        return limitInfo;
    }
}