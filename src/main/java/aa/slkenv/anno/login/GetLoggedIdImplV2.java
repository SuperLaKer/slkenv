package aa.slkenv.anno.login;

import org.springframework.core.Conventions;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author slk
 * @date 2021
 */
public class GetLoggedIdImplV2 implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isSupports = parameter.hasParameterAnnotation(getCurrentId.class);
        System.out.println(isSupports);
        return isSupports;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        parameter = parameter.nestedIfOptional();
        String id = (String) webRequest.getAttribute("userId", 0);
        String name = Conventions.getVariableNameForParameter(parameter);
        System.out.println(name);
        assert id != null;
        return new Integer(id);
    }
}
