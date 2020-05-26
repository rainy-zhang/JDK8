package lombok;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 22:45
 */
@ToString(
//        includeFieldNames = false, 不包含属性名
//        of = {"field2"}, 设置某些属性生成toString方法, 没有被指定的属性将不会生成toString方法
//        exclude = {"filed1"}, 指定某些属性不生成toString方法
//        callSuper = false, toString方法是否会调用父类的toString方法
//        doNotUseGetters = false, 将会不使用get方法获取属性值, 直接使用属性名获取, 在get中封装的处理逻辑将不会被触发

)
public class ToStringTest {

    private String filed1;

    private String filed2;

    private String filed3;


}
