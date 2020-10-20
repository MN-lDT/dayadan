package com.yadanoa.dayadan.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer roleId;

    private Integer permission;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permission=" + permission +
                "}";
    }

}
