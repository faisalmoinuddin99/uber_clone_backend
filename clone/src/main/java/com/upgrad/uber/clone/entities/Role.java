package com.upgrad.uber.clone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name="role_id")
    @GeneratedValue
    private int roleId;

    @Column(name="role_name",nullable = false,unique = true)
    private String roleName;

    @JsonBackReference
    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Set<Users> usersSet;

    public Role() {

    }


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

}
