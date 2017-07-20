package zhoulifeng.bomb;

import cn.bmob.v3.BmobObject;

/**
 * Author: Zachary
 * Time: 2017/07/20 上午 11:13
 * Desc:
 */

public class Me extends BmobObject {
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    private static final long serialVersionUID = 1L;
    private String user_name;
    private String user_pwd;

}
