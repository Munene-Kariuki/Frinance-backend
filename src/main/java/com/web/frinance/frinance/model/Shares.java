package com.web.frinance.frinance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "users", schema = "public")
public class Shares {
    private String user_modified ;
    private Date date_modified ;
    @Id
    private Integer transaction_id ;
    private String member_no ;
    private Integer amount ;

    public String getUser_modified() {
        return user_modified;
    }

    public void setUser_modified(String user_modified) {
        this.user_modified = user_modified;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getMember_no() {
        return member_no;
    }

    public void setMember_no(String member_no) {
        this.member_no = member_no;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
