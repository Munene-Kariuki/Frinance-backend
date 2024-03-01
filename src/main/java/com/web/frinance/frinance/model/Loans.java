package com.web.frinance.frinance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "loans", schema = "public")
public class Loans {
    private String user_modified ;
    private Date date_modified ;
    @Id
    private String loan_id ;
    private String member_no ;
    private Date loan_date ;
    private Integer loan_amount ;
    private String payment_indicator ;
    private Date repayment_date ;
    private Integer repayment_amount ;

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

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getMember_no() {
        return member_no;
    }

    public void setMember_no(String member_no) {
        this.member_no = member_no;
    }

    public Date getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    public Integer getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(Integer loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getPayment_indicator() {
        return payment_indicator;
    }

    public void setPayment_indicator(String payment_indicator) {
        this.payment_indicator = payment_indicator;
    }

    public Date getRepayment_date() {
        return repayment_date;
    }

    public void setRepayment_date(Date repayment_date) {
        this.repayment_date = repayment_date;
    }

    public Integer getRepayment_amount() {
        return repayment_amount;
    }

    public void setRepayment_amount(Integer repayment_amount) {
        this.repayment_amount = repayment_amount;
    }

    public Integer getLoan_balance() {
        return loan_balance;
    }

    public void setLoan_balance(Integer loan_balance) {
        this.loan_balance = loan_balance;
    }

    private Integer loan_balance ;
}
