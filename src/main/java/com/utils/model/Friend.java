package com.utils.model;

public class Friend {
    private Integer id;
    private String nick_name;
    private String cover;
    private String linked_member_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLinked_member_id() {
        return linked_member_id;
    }

    public void setLinked_member_id(String linked_member_id) {
        this.linked_member_id = linked_member_id;
    }
}
