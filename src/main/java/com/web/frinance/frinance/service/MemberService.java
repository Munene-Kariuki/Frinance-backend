package com.web.frinance.frinance.service;

import com.web.frinance.frinance.pojo.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    ResponseEntity<?> getMemberInfo(String member_no) throws Exception ;
}
