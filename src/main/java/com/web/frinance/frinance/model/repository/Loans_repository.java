package com.web.frinance.frinance.model.repository;

import com.web.frinance.frinance.model.Loans;
import com.web.frinance.frinance.model.Shares;
import com.web.frinance.frinance.pojo.Totals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Loans_repository extends CrudRepository <Loans, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM LOANS WHERE MEMBER_NO = :member_no" +
            " AND PAYMENT_INDICATOR IN ('unpaid', 'partial')")
    public List<Loans> fetchUserLoans(@Param("member_no") String member_no);
    @Query(nativeQuery = true, value = "SELECT sum(amount) as total FROM LOANS " +
            "WHERE MEMBER_NO = :member_no AND PAYMENT_INDICATOR IN ('unpaid', 'partial')")
    public List<Totals> getTotalLoans(@Param("member_no") String member_no);
}
