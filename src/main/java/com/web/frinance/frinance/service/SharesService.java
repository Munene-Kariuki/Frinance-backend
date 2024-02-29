package com.web.frinance.frinance.service;

import org.springframework.http.ResponseEntity;

public interface SharesService {
    ResponseEntity<?> getShares(String member_no) throws Exception ;
}
