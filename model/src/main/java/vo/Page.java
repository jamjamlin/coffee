package vo;

import java.io.Serializable;

public class Page implements Serializable {
    private static final long serialVersionUID = 1L;
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
