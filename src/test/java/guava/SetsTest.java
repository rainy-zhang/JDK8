package guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 14:55
 */
public class SetsTest {

    /**
     * Sets 工具类的常用方法
     * 并集 / 交集 / 差集 / 分解子集 / 笛卡尔积
     *
     * Lists 工具类的常用方法
     * 反转 / 拆分
     */

    private static final Set set1 = Sets.newHashSet(1, 2, 3, 4);
    private static final Set set2 = Sets.newHashSet(4, 5, 6);

    @Test
    public void union() {   //求两个集合的并集
        Set result = Sets.union(set1, set2);
        System.out.println("result = " + result);
    }

    @Test
    public void intersection() {  //求两个集合的交集
        Set result = Sets.intersection(set1, set2);
        System.out.println("result = " + result);
    }

    @Test
    public void difference() {  //求两个集合的差集: 返回set1中存在, set2中不存在的数据
        Set result = Sets.difference(set1, set2);
        System.out.println("result = " + result);

        // 相对差集: 属于set1而且不属于set2, 或者属于set2而且不属于set1
        result = Sets.symmetricDifference(set1, set2);
        System.out.println("result = " + result);

    }

    @Test
    public void powerSet() {    // 拆分出集合中所有能组合的子集
        Set<Set> result = Sets.powerSet(set1);
        System.out.println("result = " + JSON.toJSONString(result, true));
    }

    @Test
    public void cartesianProduct() {    // 计算两个集合的笛卡尔积
        Set<List> result = Sets.cartesianProduct(set1, set2);
        System.out.println("result = " + JSON.toJSONString(result, true));
    }


    @Test
    public void partition() {   // 将集合拆分成指定元素个数的子集
        List list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        List<List> partition = Lists.partition(list, 3);
        System.out.println("partition = " + JSON.toJSONString(partition, true));
    }

    @Test
    public void reverse() {  //反转集合中的元素
        List list = Lists.newLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        List reverse = Lists.reverse(list);
        System.out.println("reverse = " + reverse);
    }

}
