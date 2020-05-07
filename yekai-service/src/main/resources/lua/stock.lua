
local currentValue = redis.call('GET', KEYS[1])
if not currentValue then
    return 'E'
end

if tonumber(currentValue) - tonumber(ARGV[1]) < 0 then
    return 'F'
end

redis.call('DECRBY',KEYS[1],ARGV[1])
return 'OK'