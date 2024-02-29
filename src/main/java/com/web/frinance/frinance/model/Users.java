package com.web.frinance.frinance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", schema = "public")
public class Users {
    private  String user_modified ;
    private LocalDateTime date_modified ;
    @Id
    private String member_no ;
    private String first_name ;
    private String last_name ;
    private String profile ;
    private String email ;
    private String password ;

    public String getUser_modified() {
        return user_modified;
    }

    public void setUser_modified(String user_modified) {
        this.user_modified = user_modified;
    }

    public String getMember_no() {
        return member_no;
    }

    public LocalDateTime getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(LocalDateTime date_modified) {
        this.date_modified = date_modified;
    }

    public void setMember_no(String member_no) {
        this.member_no = member_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
