package validation;

import javax.validation.Valid;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/23 13:13
 */
public class UserInfoService {

    public void setUserInfo(@Valid UserInfo userInfo) {

    }

    public @Valid UserInfo getUserInfo() {
        return new UserInfo();
    }

    public UserInfoService() {

    }

    public UserInfoService(@Valid UserInfo userInfo) {

    }

}
