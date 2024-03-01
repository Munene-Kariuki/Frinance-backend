package com.web.frinance.frinance.service;

import com.web.frinance.frinance.pojo.SharesPOJO;
import org.springframework.http.ResponseEntity;

public interface SharesService {
    ResponseEntity<?> getShares(String member_no) throws Exception ;
    ResponseEntity<?> postShares(SharesPOJO sharesPOJO) throws Exception ;
}
