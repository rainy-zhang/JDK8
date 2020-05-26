package lombok;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 23:05
 */
//@AllArgsConstructor  // 全参的构造方法注解
//@NoArgsConstructor   // 无参的构造方法注解
@RequiredArgsConstructor  // 必要参数的构造方法注解, 会找出不能为空的属性创造出构造方法, 比如final修饰的属性
public class ConstructorTest {

    private final String field1;

    @NonNull
    private String field2;

    private String field3;

}
