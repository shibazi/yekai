package com.yekai.limiter.service.symbol;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 运算符
 *
 *
 * @author : LZQ Date: 2020/05/11  Version: 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SymbolEnum {

    /**
     * 优先级
     *
     * @return 优先级
     */
    Level level();

    /**
     * 名称
     *
     * @return 名称
     */
    String name();

    /**
     * 符号
     *
     * @return 符号
     */
    String symbol();
}
