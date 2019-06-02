package org.icode.msp.user.domain;

import java.util.List;

public class PageInfo<T> {
    private Long total;
    private Integer totalPage;
    private List<T> list;

    public PageInfo(){}

    public PageInfo(Long total, Integer totalPage, List<T> list) {
        this.total = total;
        this.totalPage = totalPage;
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "total=" + total +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
