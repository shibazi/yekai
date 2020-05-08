package com.yekai.limiter.service.biz;


import java.util.List;

/**
 * lua脚本执行器
 *
 * <p>
 *     1、加载脚本
 *     2、执行命令
 * </p>
 *
 * @author : LZQ Date: 2020/04/29  Version: 1.0
 */
public interface LuaExecutor {

    /**
     * 加载脚本
     *
     * @param script    lua脚本
     * @return          SHA1
     */
    String load(String script);

    /**
     * 执行命令
     *
     * @param keys      key值
     * @param args      arg值
     * @return          执行结果
     */
    String execute(List<String> keys,List<String> args);
}