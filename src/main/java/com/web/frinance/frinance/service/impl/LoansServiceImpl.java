package com.web.frinance.frinance.service.impl;

import com.web.frinance.frinance.model.Loans;
import com.web.frinance.frinance.model.Shares;
import com.web.frinance.frinance.model.Users;
import com.web.frinance.frinance.model.repository.Loans_repository;
import com.web.frinance.frinance.model.repository.Users_repository;
import com.web.frinance.frinance.pojo.ErrorResponse;
import com.web.frinance.frinance.service.LoansService;
import com.web.frinance.frinance.util.annotation.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Facade
public class LoansServiceImpl implements LoansService {
    @Autowired
    private Loans_repository loansRepository ;
    @Autowired
    private Users_repository usersRepository ;
    @Override
    public ResponseEntity<?> getLoans(String member_no) throws Exception {
        List<Users> users  = usersRepository.fetchUserInfo(member_no);
        if(users.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(404);
            errorResponse.setErrorMessage("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        List<Loans> loans  = loansRepository.fetchUserLoans(member_no.toUpperCase());
        List<Loans> loansArray = new ArrayList<>(loans);
        return ResponseEntity.status(HttpStatus.OK).body(loansArray);
    }
}
