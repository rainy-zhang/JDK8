package guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 14:30
 */
public class MultisetTest {

    private static final String text =
            "《南陵别儿童入京》" +
                    "白酒新熟山中归，黄鸡啄黍秋正肥。" +
                    "呼童烹鸡酌白酒，儿女嬉笑牵人衣。" +
                    "高歌取醉欲自慰，起舞落日争光辉。" +
                    "游说万乘苦不早，著鞭跨马涉远道。" +
                    "会稽愚妇轻买臣，余亦辞家西入秦。" +
                    "仰天大笑出门去，我辈岂是蓬蒿人。";

    /**
     * multiset: 无序可重复集合
     */
    @Test
    public void test() {
        Multiset multiset = HashMultiset.create();

        char[] chars = text.toCharArray();

        Chars.asList(chars)
                .stream()
                .forEach(item -> {
                    multiset.add(item);
                });

        System.out.println("size: " + multiset.size());
        System.out.println("count: " + multiset.count('人'));
    }

}
