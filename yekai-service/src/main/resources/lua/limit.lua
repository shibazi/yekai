local keys = KEYS
local values = ARGV

for i,key in ipairs(keys) do
    local currentValue = redis.call('GET', key)
    if not currentValue then
        currentValue = '0'
        redis.call('SET', key, '0', 'ex', 1)
    end

    if tonumber(currentValue) + 1 > tonumber(values[i]) then
        return key
    end
end

for key in ipairs(keys) do
    redis.call('INCR',key,1)
end

return 'OK'