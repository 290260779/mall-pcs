package com.utils.model;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-23 18:36
 */
public class ListScheduleParaModel {
    private int memberId;
    private int scheduleType;
    private int pageNum;
    private int pageSize;
    private String parameter;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(int scheduleType) {
        this.scheduleType = scheduleType;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public ListScheduleParaModel() {
    }

    @Override
    public String toString() {
        return "ListScheduleParaModel{" +
                "memberId=" + memberId +
                ", scheduleType=" + scheduleType +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", parameter='" + parameter + '\'' +
                '}';
    }
}
