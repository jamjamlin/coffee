package vo;

import java.io.Serializable;

public class UserLoginVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
