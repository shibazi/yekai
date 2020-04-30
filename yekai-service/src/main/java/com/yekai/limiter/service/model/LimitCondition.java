package com.yekai.limiter.service.model;

import com.google.common.base.Joiner;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Collections;
import java.util.List;

/**
 * 限流key 列表
 *
 * @author : LZQ Date: 2020/04/27  Version: 1.0
 */
@EqualsAndHashCode
@NoArgsConstructor
public class LimitCondition {

    /**
     * 条件列表
     */
    @Getter
    @Setter
    public List<LimitKeyBO> keys;

    /**
     * 流量
     */
    @Getter
    @Setter
    public Integer permitsPreSecond;

    /**
     * 重写 get 方法
     *   无 set 方法
     *
     * @return 排序后拼接的字符串
     */
    public String getKeyString() {
        return toString();
    }

    /**
     * 重写toString方法
     *
     * @return  排序后拼接的字符串
     */
    @Override
    public String toString() {
        Collections.sort(keys);
        return Joiner.on("&").join(keys);
    }

    /**
     * 构造方法
     *
     * @param keys              条件列表
     */
    public LimitCondition(List<LimitKeyBO> keys) {
        this.keys = keys;
    }

    /**
     * 构造方法
     *
     * @param keys              条件列表
     * @param permitsPreSecond  流量
     */
    public LimitCondition(List<LimitKeyBO> keys, Integer permitsPreSecond) {
        this.keys = keys;
        this.permitsPreSecond = permitsPreSecond;
    }

}