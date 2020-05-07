package com.yekai.limiter.service.biz;

/**
 * 库存脚本执行器:单例实例
 *
 * <p>
 *     1、构造方法
 * </p>
 *
 * @author : LZQ Date: 2020/05/07  Version: 1.0
 */
public class StockExecutor extends SentinelLuaExecutor {

//    private final static String SCRIPT = "redis.call('SET', '00001',10)";

    /**
     * 脚本
     */
    private final static String SCRIPT =
                    "local currentValue = redis.call('GET', KEYS[1])\n" +
                            "if not currentValue then\n" +
                            "    return 'E'\n" +
                            "end\n" +
                            "\n" +
                            "if tonumber(currentValue) - tonumber(ARGV[1]) < 0 then\n" +
                            "    return 'F'\n" +
                            "end\n" +
                            "\n" +
                            "redis.call('DECRBY',KEYS[1],ARGV[1])\n" +
                            "return 'OK'";

    /**
     * 私有构造方法
     */
    private StockExecutor() {
        load(SCRIPT);
    }

    /**
     * 单例
     */
    private static final LuaExecutor EXECUTOR = new StockExecutor() ;

    /**
     * 获取执行器
     *
     * @return      执行器
     */
    public static LuaExecutor getExecutor(){
        return EXECUTOR;
    }

}
