package com.opdapp.model.admin;

import javax.persistence.*;

@Entity
@Table
public class MedSysUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 1-Doctor, 2- Nurse
    private int userType;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
