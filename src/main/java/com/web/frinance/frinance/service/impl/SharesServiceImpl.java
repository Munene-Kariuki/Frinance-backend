package com.web.frinance.frinance.service.impl;

import com.web.frinance.frinance.model.Shares;
import com.web.frinance.frinance.model.Users;
import com.web.frinance.frinance.model.repository.Shares_repository;
import com.web.frinance.frinance.model.repository.Users_repository;
import com.web.frinance.frinance.pojo.ErrorResponse;
import com.web.frinance.frinance.pojo.SharesPOJO;
import com.web.frinance.frinance.pojo.Totals;
import com.web.frinance.frinance.pojo.TotalsPOJO;
import com.web.frinance.frinance.service.SharesService;
import com.web.frinance.frinance.util.annotation.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Facade
public class SharesServiceImpl implements SharesService {
    @Autowired
    private Shares_repository sharesRepository ;
    @Autowired
    private Users_repository usersRepository ;
    @Override
    public ResponseEntity<?> getShares(String member_no) throws Exception {
        List<Users> users  = usersRepository.fetchUserInfo(member_no);
        if(users.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(404);
            errorResponse.setErrorMessage("User " + member_no + " does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        List <Totals> totalShares = sharesRepository.getTotalShares(member_no);
        List <Shares> shares = sharesRepository.fetchUserShares(member_no) ;
        List<Shares> sharesArrayList = new ArrayList<>(shares);
        return ResponseEntity.status(HttpStatus.OK).body(sharesArrayList);
    }

    @Override
    public ResponseEntity<?> getTotalShares(String member_no) throws Exception {
        List<Users> users  = usersRepository.fetchUserInfo(member_no);
        if(users.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(404);
            errorResponse.setErrorMessage("User " + member_no + " does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        List <Totals> totalShares = sharesRepository.getTotalShares(member_no);
        return ResponseEntity.status(HttpStatus.OK).body(totalShares);
    }

    @Override
    public ResponseEntity<?> postShares(SharesPOJO sharesPOJO) throws Exception {
        List<Users> users  = usersRepository.fetchUserInfo(sharesPOJO.getMember_no().toUpperCase());
        if(users.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(404);
            errorResponse.setErrorMessage("User " + sharesPOJO.getMember_no().toUpperCase() + " does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        Shares shares = new Shares();
        shares.setUser_modified(sharesPOJO.getUser_modified());
        shares.setMember_no(sharesPOJO.getMember_no());
        shares.setAmount(sharesPOJO.getAmount());
        shares.setDate_modified(LocalDateTime.now());
        sharesRepository.save(shares);
        return ResponseEntity.status(HttpStatus.OK).body(shares);
    }
}
