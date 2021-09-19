package aa.slkenv.utils.redis;

import aa.slkenv.utils.redis.config.RedisUtilsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Import({RedisUtilsConfig.class})
public class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;

    public RedisUtils() {
    }

    public void set(String key, Object value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, Object value, long timeout, TimeUnit unit) {
        this.redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public boolean setIfAbsent(String key, Object value, long timeout, TimeUnit unit) {
        return this.redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
    }

    public <T> T get(String key, Class<?> T) {
        return (T) this.redisTemplate.opsForValue().get(key);
    }

    public String get(String key) {
        return (String) this.redisTemplate.opsForValue().get(key);
    }

    public Long decr(String key) {
        return this.redisTemplate.opsForValue().decrement(key);
    }

    public Long decr(String key, long delta) {
        return this.redisTemplate.opsForValue().decrement(key, delta);
    }

    public Long incr(String key) {
        return this.redisTemplate.opsForValue().increment(key);
    }

    public Long incr(String key, long delta) {
        return this.redisTemplate.opsForValue().increment(key, delta);
    }

    public void publish(String channel, Object message) {
        this.redisTemplate.convertAndSend(channel, message);
    }
}
