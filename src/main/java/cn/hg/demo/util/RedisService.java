package cn.hg.demo.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set : string类型
     */
    public void setString(String key, String value){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    /**
     * get : string类型
     */
    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

}
