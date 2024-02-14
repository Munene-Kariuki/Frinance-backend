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
}
