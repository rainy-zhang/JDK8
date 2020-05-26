package lombok;


import com.sun.istack.internal.NotNull;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 22:25
 */
public class GetterTest {


    @Getter
    private String field1;

    @Getter(
            value = AccessLevel.PRIVATE,  // 定义生成的get方法的访问权限
            onMethod_={@NotNull}  // 为生成的get方法添加额外的注解
    )
    private String field2;

    @Getter(lazy = true) // lazy=true时, 只有在使用的时候才会初始化 (懒加载)
    private final String field3 = "zhangxiaoyu";


}
