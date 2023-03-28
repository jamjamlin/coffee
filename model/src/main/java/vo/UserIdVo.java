package vo;

import java.io.Serializable;

public class UserIdVo implements Serializable {
    private static final long serialVersionUID = 1L;
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
