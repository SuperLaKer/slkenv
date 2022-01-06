package aa.slkenv.anno.login;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author slk
 * @date 2021
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(GetCurrentIdImplV1.class)
public @interface getCurrentId {
    boolean required() default true;
    // 请求体中id字段的名字：id, userId, loginId等
    String requestIdName() default "id";

    String value() default "id";
}
