package vo;

import java.io.Serializable;

/**
 *
 * 角色条件查询实体
 *
 */


public class UserQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    private String UserName;
}
