package com.web.frinance.frinance.model.repository;

import com.web.frinance.frinance.model.Shares;
import com.web.frinance.frinance.pojo.Totals;
import com.web.frinance.frinance.pojo.TotalsPOJO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Shares_repository extends CrudRepository <Shares, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM SHARES WHERE MEMBER_NO = :member_no")
    public List<Shares> fetchUserShares(@Param("member_no") String member_no);
    @Query(nativeQuery = true, value = "SELECT sum(amount) as total FROM SHARES WHERE MEMBER_NO = :member_no")
    public List<Totals> getTotalShares(@Param("member_no") String member_no);
}
