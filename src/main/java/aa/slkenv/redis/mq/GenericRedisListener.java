package aa.slkenv.redis.mq;

import aa.slkenv.sys.SlkEenGlobalConst;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * 继承此类，重写onMessage方法
 */
@Component
@NoArgsConstructor
public class GenericRedisListener implements MessageListener {

    private String redisMQChannel = SlkEenGlobalConst.REDIS_DEFAULT_LISTENER_CHANNEL;

    public GenericRedisListener(String redisMQChannel) {
        this.redisMQChannel = redisMQChannel;
    }

    @Override
    public void onMessage(Message message, @Nullable byte[] pattern) {
        System.out.println("请实现此接口：" + GenericRedisListener.class.getName());
        System.out.println("收到消息: " + new String(message.getBody(), StandardCharsets.UTF_8));
    }

    protected MessageListenerAdapter getListenerAdapter() {
        return new MessageListenerAdapter(this);
    }

    protected ChannelTopic getChannelTopic() {
        return new ChannelTopic(this.redisMQChannel);
    }


}