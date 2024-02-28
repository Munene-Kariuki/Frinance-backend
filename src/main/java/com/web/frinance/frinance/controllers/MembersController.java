package com.web.frinance.frinance.controllers;

import com.web.frinance.frinance.pojo.LoginPOJO;
import com.web.frinance.frinance.pojo.MemberRequest;
import com.web.frinance.frinance.pojo.UserResponse;
import com.web.frinance.frinance.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/")
public class MembersController {
    @Autowired
    MemberService memberService ;
    @RequestMapping( path = "getMemberInfo/", method = RequestMethod.POST)
    public ResponseEntity<?> getMemberInfo(@RequestBody MemberRequest memberRequest) throws Exception {
        return memberService.getMemberInfo(memberRequest.getMember_no());
    }
    @RequestMapping( path = "login/", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginPOJO loginPOJO) throws Exception {
        return memberService.login(loginPOJO);
    }
}
