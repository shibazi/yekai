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
public class SentinelLuaExecutor implements LuaExecutor {

    /**
     * 缓存脚本的 sha 码
     */
    private static String sha = null;

    /**
     * 私有构造方法
     */
    private SentinelLuaExecutor() {
        load();
    }

    /**
     * 单例
     */
    private static final LuaExecutor EXECUTOR = new SentinelLuaExecutor() ;

    /**
     * 获取执行器
     *
     * @return      执行器
     */
    public static LuaExecutor getExecutor(){
        return EXECUTOR;
    }

    /**
     * 限流脚本
     */
    private static final String SCRIPT = "local keys = KEYS\n" +
            "local values = ARGV\n" +
            "\n" +
            "for i,key in ipairs(keys) do\n" +
            "    local currentValue = redis.call('GET', key)\n" +
            "    if not currentValue then\n" +
            "        currentValue = '0'\n" +
            "        redis.call('SET', key, '0', 'ex', 1)\n" +
            "    end\n" +
            "\n" +
            "    if tonumber(currentValue) + 1 > tonumber(values[i]) then\n" +
            "        return key\n" +
            "    end\n" +
            "end\n" +
            "\n" +
            "for key in ipairs(keys) do\n" +
            "    redis.call('INCR',key)\n" +
            "end\n" +
            "\n" +
            "return 'OK'" ;

    /**
     * 加载脚本
     *
     */
    @Override
    public String load() {
        sha = RedisClient.getRedis().scriptLoad(SCRIPT);
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