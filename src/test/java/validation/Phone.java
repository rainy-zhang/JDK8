package validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
//  注解的作用目标
@Target({ElementType.FIELD})
// 注解的保留策略
@Retention(RetentionPolicy.RUNTIME)
// 指定注解的验证器
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    // 当注解验证失败后返回给客户端的信息
    String message() default "手机号格式错误";

    // 约束注解在验证时所属的组别
    Class<?>[] groups() default {};

    // 注解的有效负载
    Class<? extends Payload>[] payload() default {};
}

