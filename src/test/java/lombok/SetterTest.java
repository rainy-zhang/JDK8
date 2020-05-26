package lombok;

import com.sun.istack.internal.NotNull;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 22:42
 */
public class SetterTest {

    @Setter
    private String field1;

    @Setter(
            value = AccessLevel.PRIVATE,
            onParam_={@NotNull}
    )
    private String field2;

}
