package com.web.frinance.frinance.service;

import com.web.frinance.frinance.pojo.LoginPOJO;
import com.web.frinance.frinance.pojo.UserProfile;
import com.web.frinance.frinance.pojo.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    ResponseEntity<?> getMemberInfo(String member_no) throws Exception ;
    ResponseEntity<?> login(LoginPOJO loginPOJO) throws Exception ;
    public boolean isCorrectPassword(String databasePassword, String userProvidedPassword) throws Exception;
    ResponseEntity<?> registerNewUser(UserProfile userProfile) throws Exception ;


}
