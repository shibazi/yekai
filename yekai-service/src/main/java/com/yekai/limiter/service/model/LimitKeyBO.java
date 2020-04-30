package com.yekai.limiter.service.model;

import com.google.common.base.Joiner;
import lombok.*;

/**
 * 限流条件明细
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LimitKeyBO implements Comparable<LimitKeyBO>{

    /**
     * key
     */
    public String key;

    /**
     * value
     */
    public String value;

    /**
     * 设置排序规则
     *      安装key的自然顺序排序
     */
    @Override
    public int compareTo(LimitKeyBO o) {
        return key.compareTo(o.key);
    }

    @Override
    public String toString() {
        return Joiner.on("=").join(key,value);
    }
}
