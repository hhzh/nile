package com.nile.controller;

public class PageRequest {

    private boolean paged = true;
    private int pageNumber = 1;
    private int pageSize = 10;
    private String orderingBy;
    private String ordering;

    public boolean isPaged() {
        return paged;
    }

    public void setPaged(boolean paged) {
        this.paged = paged;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderingBy() {
        return orderingBy;
    }

    public void setOrderingBy(String orderingBy) {
        this.orderingBy = orderingBy;
    }

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }
}
