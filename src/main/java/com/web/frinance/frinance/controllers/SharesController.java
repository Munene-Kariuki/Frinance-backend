package com.web.frinance.frinance.controllers;

import com.web.frinance.frinance.pojo.MemberRequest;
import com.web.frinance.frinance.pojo.SharesPOJO;
import com.web.frinance.frinance.service.MemberService;
import com.web.frinance.frinance.service.SharesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/shares/")
public class SharesController {
    @Autowired
    SharesService sharesService;
    @RequestMapping( path = "sharesInfo/", method = RequestMethod.POST)
    public ResponseEntity<?> sharesInfo(@RequestBody MemberRequest memberRequest) throws Exception {
        return sharesService.getShares(memberRequest.getMember_no());
    }
    @RequestMapping( path = "postShares/", method = RequestMethod.POST)
    public ResponseEntity<?> addShares(@RequestBody SharesPOJO sharesPOJO) throws Exception {
        return sharesService.postShares(sharesPOJO);
    }
}
