package aa.slkenv.utils.redis.defaults;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.lang.Nullable;

import java.nio.charset.StandardCharsets;


public interface DefaultRedisChannelListener extends MessageListener {
    @Override
    default void onMessage(Message message, @Nullable byte[] pattern) {
        System.out.println("请实现此接口：" + DefaultRedisChannelListener.class.getName());
        System.out.println("收到消息: " + new String(message.getBody(), StandardCharsets.UTF_8));
    }
}