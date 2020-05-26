package lombok;

import com.sun.istack.internal.NotNull;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 23:00
 */
@EqualsAndHashCode(
        onParam_={@NotNull}
)
public class EquealsAndHashCode {

    private String field1;

}
