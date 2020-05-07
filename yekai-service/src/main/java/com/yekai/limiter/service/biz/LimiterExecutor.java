package com.yekai.limiter.service.biz;

/**
 * 限流脚本执行器:单例实例
 *
 * <p>
 *     1、构造方法
 * </p>
 *
 * @author : LZQ Date: 2020/05/07  Version: 1.0
 */
public class LimiterExecutor extends SentinelLuaExecutor {

    /**
     * 脚本
     */
    private final static String SCRIPT = "local keys = KEYS\n" +
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
     * 私有构造方法
     */
    private LimiterExecutor() {
        load(SCRIPT);
    }

    /**
     * 单例
     */
    private static final LuaExecutor EXECUTOR = new LimiterExecutor() ;

    /**
     * 获取执行器
     *
     * @return      执行器
     */
    public static LuaExecutor getExecutor(){
        return EXECUTOR;
    }

}
