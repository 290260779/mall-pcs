package com.utils.model;

public class MemberFriend {


    private Integer id;
    private String name;
    private String cover;
    private int linked_member_id;
    private int linked_group_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getLinked_member_id() {
        return linked_member_id;
    }

    public void setLinked_member_id(int linked_member_id) {
        this.linked_member_id = linked_member_id;
    }

    public int getLinked_group_id() {
        return linked_group_id;
    }

    public void setLinked_group_id(int linked_group_id) {
        this.linked_group_id = linked_group_id;
    }
}
