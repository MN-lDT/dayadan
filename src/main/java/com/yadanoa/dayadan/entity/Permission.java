package com.yadanoa.dayadan.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 说明
     */
    private String remarks;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName=" + permissionName +
                ", remarks=" + remarks +
                "}";
    }
}
