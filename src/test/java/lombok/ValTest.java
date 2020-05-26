package lombok;

import java.util.ArrayList;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 23:01
 */
public class ValTest {

    // @Val注解: 若语言变量
    public ValTest() {
        val field = "zhangxiaoyu";

        val list = new ArrayList<String>();
        list.add(field);
    }

}
