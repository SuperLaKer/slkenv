package aa.slkenv.security.oath;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

/**
 * by lla, at 2022/1/25 15:25
 */
@Data
@Configuration
@EnableWebSecurity
@EnableResourceServer
@ConfigurationProperties(prefix = "key.store")
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Import({GenericResourceServerConfigurer.class, GenericWebSecurityConfigurer.class})
public class SecurityResourceServerAutoImport {

    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("资源服务器自动配置:\n");
        stringBuilder.append("依赖: 2.3.12.RELEASE, Hoxton.SR12\n");
        stringBuilder.append("依赖：spring-boot-starter-oauth2-resource-server,");
        stringBuilder.append("spring-cloud-starter-oauth2:2.2.5.RELEASE\n");
        stringBuilder.append("可自定义密钥库\n");
        stringBuilder.append("继承两个Generic配置security框架相关参数：\n");
        stringBuilder.append("GenericWebSecurityConfigurer, GenericResourceServerConfigurer");
        System.out.println("\033[33;1;1m" + stringBuilder + "\033[0m");
    }

    private Boolean jwtEnable = true;
    private String KeyStoreName = "slkSecretKey.store";
    private String KeyStoreAlias = "slkSecretKeyStore";
    private String KeyStorePassword = "slkroot";
    private String SecretKeyPassword = "slkroot";

    @Autowired
    private KeyPair keyPair;

    @Bean
    @Primary
    KeyPair keyPair() {
        Resource keyStoreResource = new ClassPathResource(this.getKeyStoreName());
        KeyStoreKeyFactory storeKeyFactory =
                new KeyStoreKeyFactory(keyStoreResource, this.getKeyStorePassword().toCharArray());
        KeyPair keyPair = storeKeyFactory.
                getKeyPair(this.getKeyStoreAlias(), this.getSecretKeyPassword().toCharArray());
        if (null == keyPair) {
            throw new RuntimeException("构建keyPair异常");
        }
        return keyPair;
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey((RSAPublicKey) keyPair.getPublic()).build();
    }

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyPair);
        return converter;
    }
}
