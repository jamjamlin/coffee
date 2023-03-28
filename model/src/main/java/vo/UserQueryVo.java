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

    private String UserId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    private Long page;
    private Long limit;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }
}
