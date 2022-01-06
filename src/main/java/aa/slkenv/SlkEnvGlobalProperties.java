package aa.slkenv;

import aa.slkenv.sys.SlkEenGlobalConst;
import org.springframework.stereotype.Component;

/**
 * by lla, at 2022/1/6 21:40
 * 重写方法添加自定义属性
 */
@Component
public class SlkEnvGlobalProperties {
    {
        String msg = "需要重写此类: "+SlkEnvGlobalProperties.class.getName();
        System.out.println("\033[33;1;1m" + msg + "\033[0m");
    }
    public String getRedisChannel() {
        return SlkEenGlobalConst.REDIS_DEFAULT_LISTENER_CHANNEL;
    }
}
