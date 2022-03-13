package top.tran4f.exam.common.swagger.annotation;

import org.springframework.context.annotation.Import;
import top.tran4f.exam.common.swagger.config.SwaggerAutoConfiguration;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableCustomSwagger2 {

}
