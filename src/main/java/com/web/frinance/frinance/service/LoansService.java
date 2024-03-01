package com.web.frinance.frinance.service;

import org.springframework.http.ResponseEntity;

public interface LoansService {
    ResponseEntity<?> getLoans(String member_no) throws Exception ;
    ResponseEntity<?> getTotalLoans(String member_no) throws Exception ;
}
