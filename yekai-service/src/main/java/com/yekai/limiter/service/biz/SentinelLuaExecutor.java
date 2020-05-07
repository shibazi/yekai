package com.yekai.limiter.service.biz;

import com.yekai.limiter.common.exception.LimitException;
import com.yekai.limiter.common.exception.ResponseCodeEnum;
import com.yekai.limiter.service.tools.RedisClient;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
 * 哨兵模式
 *
 * <p>
 *     1、加载脚本
 *     2、执行命令
 * </p>
 *
 * @author : LZQ Date: 2020/04/29  Version: 1.0
 */
@Slf4j
public abstract class SentinelLuaExecutor implements LuaExecutor {

    /**
     * 缓存脚本的 sha 码
     */
    static String sha = null;

    /**
     * 加载脚本
     *
     */
    @Override
    public String load(String script) {
        sha = RedisClient.getRedis().scriptLoad(script);
        return sha;
    }

    /**
     * 执行命令
     *
     * @param keys  key值
     * @param args  arg值
     */
    @Override
    public String execute(List<String> keys, List<String> args) {
        try {
            return (String)RedisClient.getRedis().evalsha(sha, keys, args);
        }catch (Exception e){
            log.error("lua 脚本执行异常:{},{}",keys,args,e);
            throw new LimitException(ResponseCodeEnum.ERR_000004);
        }
    }

}