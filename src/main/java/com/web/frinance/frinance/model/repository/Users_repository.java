package com.web.frinance.frinance.model.repository;

import com.web.frinance.frinance.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Users_repository extends CrudRepository <Users, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM USERS WHERE MEMBER_NO = :member_no")
    public List<Users> fetchUserInfo(@Param("member_no") String member_no);
}
