package com.fidofi.model;

/**
 * Created by fido on 2017/10/1.
 * 分页Page
 */
public class Page {
    private Integer index;//处于第几页
    private Integer total;//共有多少页

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
