package aa.slkenv.security.oath;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * by lla, at 2022/1/25 16:01
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SecurityResourceServerAutoImport.class)
public @interface EnableMyResourceServer {
}
