package aa.slkenv.anno.login;

import org.springframework.core.Conventions;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;

import java.util.List;

/**
 * @author slk
 * @date 2021
 */
@Component
public class GetCurrentIdImplV1 extends AbstractMessageConverterMethodProcessor implements HandlerMethodArgumentResolver {

    public GetCurrentIdImplV1(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isSupports = parameter.hasParameterAnnotation(getCurrentId.class);
        System.out.println(isSupports);
        return isSupports;
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        parameter = parameter.nestedIfOptional();
        getCurrentId getCurrentId = parameter.getParameterAnnotation(getCurrentId.class);
        String requestName = (getCurrentId == null) ? "id" : getCurrentId.requestIdName();
        Object id = webRequest.getAttribute(requestName, 0);
        String name = Conventions.getVariableNameForParameter(parameter);
        System.out.println(name);
        return adaptArgumentIfNecessary(id, parameter);
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return false;
    }

    @Override
    public void handleReturnValue(
            Object returnValue, MethodParameter returnType,
            ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        System.out.println("xx");
    }
}
