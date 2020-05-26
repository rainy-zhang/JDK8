package validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/23 11:45
 */
public class ValidationTest {

    private Validator validator;

    private UserInfo userInfo;

    private Set<ConstraintViolation<UserInfo>> set;

    private Set<ConstraintViolation<UserInfoService>> otherSet;


    @Before
    public void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        userInfo = new UserInfo();
//        userInfo.setUserId("zhangxiaoxi");
        userInfo.setUserName("张小喜");
        userInfo.setPassWord("zhangxiaoxi");
//        userInfo.setEmail("zhangxiaoxi@sina.cn");
        userInfo.setAge(30);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, 1, 1);
        userInfo.setBirthday(calendar.getTime());

        userInfo.setPhone("15800000000");

        UserInfo friend = new UserInfo();
//        friend.setUserId("wangxiaoxi");
        friend.setUserName("王小喜");
        friend.setPassWord("wangxiaoxi");
//        friend.setEmail("wangxiaoxi@sina.cn");
        friend.setPhone("15811111111");

        userInfo.setFriends(new ArrayList(){{add(friend);}});
    }

    @After
    public void print() {
//        set.stream().forEach(System.out::println);
        otherSet.forEach(item -> {
            System.out.println(item.getMessage());
        });
    }

    @Test
    public void nullValidation() {
        // 使用验证器对对象进行验证
        set = validator.validate(userInfo);
    }

    /**
     * 级联验证测试方法
     */
    @Test
    public void graphValidation() {
        set = validator.validate(userInfo);
    }

    /**
     * 分组验证测试方法
     */
    @Test
    public void groupValidation() {
        set = validator.validate(userInfo,
                UserInfo.RegisterGroup.class,
                UserInfo.LoginGroup.class);
    }

    /**
     * 组序列
     */
    @Test
    public void groupSequenceValidation() {
        set = validator.validate(userInfo,
                UserInfo.Group.class);
    }

    /**
     * 对方法的输入参数进行校验
     */
    @Test
    public void paramValidation() throws NoSuchMethodException {
        // 获取校验执行器
        ExecutableValidator executableValidator = validator.forExecutables();

        // 待验证的对象
        UserInfoService userInfoService = new UserInfoService();
        // 待验证的方法
        Method method = userInfoService.getClass().getMethod("setUserInfo", UserInfo.class);
        // 待验证的参数
        Object[] params = new Object[]{new UserInfo()};

        otherSet = executableValidator.validateParameters(userInfoService, method, params);
    }

    /**
     * 对方法的返回值进行校验
     */
    @Test
    public void returnValueValidationTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ExecutableValidator executableValidator = validator.forExecutables();

        // 待校验的对象
        UserInfoService userInfoService = new UserInfoService();
        // 待校验的方法
        Method method = userInfoService.getClass().getMethod("getUserInfo");
        // 待校验的返回值
        Object returnValue = method.invoke(userInfoService);

        otherSet = executableValidator.validateReturnValue(userInfoService, method, returnValue);
    }

    /**
     * 对构造方法的输入参数进行校验
     */
    @Test
    public void constructorValidationTest() throws NoSuchMethodException {
        ExecutableValidator executableValidator = validator.forExecutables();

        // 待验证的对象
        UserInfoService userInfoService = new UserInfoService();
        // 待验证的构造函数
        Constructor<? extends UserInfoService> constructor = userInfoService.getClass().getConstructor(UserInfo.class);
        // 待验证的参数
        Object[] parameters = new Object[]{new UserInfo()};

        otherSet = executableValidator.validateConstructorParameters(constructor, parameters);
    }

}
