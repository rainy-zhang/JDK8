package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/23 14:32
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    /**
     * 自定义校验逻辑方法
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String check = "159\\d{8}";
        Pattern regex = Pattern.compile(check);
        // 处理null
        value = Optional.ofNullable(value).orElse("");
        Matcher matcher = regex.matcher(value);
        return matcher.matches();
    }
}
