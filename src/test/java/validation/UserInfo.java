package validation;

import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/23 11:44
 */
public class UserInfo {

    // 登陆场景
    public interface LoginGroup {}

    // 注册场景
    public interface RegisterGroup {}

    // 组排序, 先验证登录组, 再验证注册组 (短路, 当有一个组验证未通过, 将不再继续验证)
    @GroupSequence({
            LoginGroup.class,
            RegisterGroup.class,
            Builder.Default.class
    })
    public interface Group {}

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空", groups = LoginGroup.class)
    private String userId;

    /**
     * 用户名
     * NotEmpty 不会自动去掉前后空格
     */
    @NotEmpty(message = "用户名称不能为空")
    private String userName;

    /**
     * 用户密码
     * NotBlank 自动去掉字符串前后空格后验证是否为空
     */
    @Length(min = 6, max = 20, message = "密码长度在6-20之间")
    private String passWord;

    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为空", groups = RegisterGroup.class)
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 手机号
     */
    @Phone(message = "手机号不是159开头的")
    private String phone;

    /**
     * 年龄
     */
    @Min(value = 18, message = "年龄不能小于18")
    @Max(value = 80, message = "年龄不能大于80")
    private Integer age;

    /**
     * 生日
     */
    @Past(message = "生日不能为未来时间")
    private Date birthday;

    /**
     * 好友列表
     * @Valid: 级联验证
     */
    @Size(min = 1, message = "不能少于一个好友")
    private List<@Valid UserInfo> friends;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<UserInfo> getFriends() {
        return friends;
    }

    public void setFriends(List<UserInfo> friends) {
        this.friends = friends;
    }

}
