package aa.slkenv.utils.redis;

import aa.slkenv.utils.redis.defaults.DefaultRedisChannelListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisMQUtils {

    {
        String msg = "消息监听需要实现此接口: DefaultRedisChannelListener...";
        System.out.println("\033[33;1;1m" + msg + "\033[0m");

        String msg1 = "个性化channel配置：${redis.mqchannel.name}, 默认channel名字：redisDefaultChannel";
        System.out.println("\033[33;1;1m" + msg1 + "\033[0m");
    }

    @Autowired
    @SuppressWarnings("ALL")
    RedisConnectionFactory connectionFactory;

    @Autowired
    @SuppressWarnings("all")
    DefaultRedisChannelListener defaultRedisChannelListener;

    @Value("${redis.mqchannel.name}")
    String redisMQChannelName;

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListenerAdapter(), channelTopic());
        return container;
    }

    @Bean("messageListenerAdapter")
    MessageListenerAdapter messageListenerAdapter() {
        return new MessageListenerAdapter(defaultRedisChannelListener);
    }


    // redis默认监听的Channel
    @Bean
    ChannelTopic channelTopic() {
        return new ChannelTopic(redisMQChannelName != null ? redisMQChannelName : "redisDefaultChannel");
    }

}
