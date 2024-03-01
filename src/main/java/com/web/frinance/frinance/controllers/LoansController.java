package com.web.frinance.frinance.controllers;

import com.web.frinance.frinance.pojo.MemberRequest;
import com.web.frinance.frinance.service.LoansService;
import com.web.frinance.frinance.service.SharesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/loans/")
public class LoansController {
    @Autowired
    LoansService loansService;
    @RequestMapping( path = "getLoans/", method = RequestMethod.POST)
    public ResponseEntity<?> loansInfo(@RequestBody MemberRequest memberRequest) throws Exception {
        return loansService.getLoans(memberRequest.getMember_no());
    }
    @RequestMapping( path = "getTotalLoans/", method = RequestMethod.POST)
    public ResponseEntity<?> totalLoans(@RequestBody MemberRequest memberRequest) throws Exception {
        return loansService.getTotalLoans(memberRequest.getMember_no());
    }
}
