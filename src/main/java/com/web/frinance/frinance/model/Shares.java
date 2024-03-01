package com.web.frinance.frinance.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shares", schema = "public")
public class Shares {
    private String user_modified ;
    private LocalDateTime date_modified ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaction_id ;
    private String member_no ;
    private Integer amount ;

    public String getUser_modified() {
        return user_modified;
    }

    public void setUser_modified(String user_modified) {
        this.user_modified = user_modified;
    }

    public LocalDateTime getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(LocalDateTime date_modified) {
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
