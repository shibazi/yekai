package com.yekai.limiter.manager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 限流配置项
 *
 * @author : LZQ Date: 2020/04/28  Version: 1.0
 */
@Getter
@Setter
@ToString
public class LimitInfoDO extends BaseDO implements Comparable<LimitInfoDO> {

    /**
     * 请求系统
     */
    private String requireSystem;

    /**
     * 优先级
     */
    private Integer level;

    /**
     * 限流key
     */
    private String key;

    /**
     * 限流值
     */
    private Integer value;

    /**
     * 状态
     */
    private String status;

    /**
     * 描述
     */
    private String desc;

    /**
     * 按优先级排序
     */
    public int compareTo(LimitInfoDO o) {
        return level - o.level;
    }

}
