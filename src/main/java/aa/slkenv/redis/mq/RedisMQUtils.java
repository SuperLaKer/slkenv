package aa.slkenv.redis.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.List;

public class RedisMQUtils {

    @Autowired
    @SuppressWarnings("all")
    RedisConnectionFactory connectionFactory;
    @Autowired
    List<GenericRedisListener> listeners;

    {
        String msg = "Redis消息队列使用：继承" + GenericRedisListener.class.getSimpleName() + "、构造参数指定监听的channel、重写onMessage方法实现监听";
        System.out.println("\033[33;1;1m" + msg + "\033[0m");
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        for (GenericRedisListener listener : listeners) {
            container.addMessageListener(listener.getListenerAdapter(), listener.getChannelTopic());
        }
        return container;
    }
}
