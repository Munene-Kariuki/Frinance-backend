package com.web.frinance.frinance.service.impl;

import com.web.frinance.frinance.model.Shares;
import com.web.frinance.frinance.model.repository.Shares_repository;
import com.web.frinance.frinance.pojo.Totals;
import com.web.frinance.frinance.pojo.TotalsPOJO;
import com.web.frinance.frinance.service.SharesService;
import com.web.frinance.frinance.util.annotation.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Facade
public class SharesServiceImpl implements SharesService {
    @Autowired
    private Shares_repository sharesRepository ;
    @Override
    public ResponseEntity<?> getShares(String member_no) throws Exception {
        List <Totals> totalShares = sharesRepository.getTotalShares(member_no);
        List <Shares> shares = sharesRepository.fetchUserShares(member_no) ;
        List<Shares> sharesArrayList = new ArrayList<>(shares);
        return ResponseEntity.status(HttpStatus.OK).body(sharesArrayList);
    }
}
