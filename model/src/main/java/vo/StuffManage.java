package vo;

import java.io.Serializable;

public class StuffManage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Stuffid;

    public String getStuffid() {
        return Stuffid;
    }

    public void setStuffid(String stuffid) {
        Stuffid = stuffid;
    }

    public String getNumberChange() {
        return NumberChange;
    }

    public void setNumberChange(String numberChange) {
        NumberChange = numberChange;
    }

    private String NumberChange;
}
