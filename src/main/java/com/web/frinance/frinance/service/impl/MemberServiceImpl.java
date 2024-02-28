package com.web.frinance.frinance.service.impl;

import com.web.frinance.frinance.model.Users;
import com.web.frinance.frinance.model.repository.Users_repository;
import com.web.frinance.frinance.pojo.ErrorResponse;
import com.web.frinance.frinance.pojo.LoginPOJO;
import com.web.frinance.frinance.pojo.UserResponse;
import com.web.frinance.frinance.service.MemberService;
import com.web.frinance.frinance.util.annotation.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Facade
public class MemberServiceImpl implements MemberService {

    @Autowired
    private Users_repository users_repository ;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public ResponseEntity<?> getMemberInfo(String member_no) throws Exception {
       List<Users> users  = users_repository.fetchUserInfo(member_no);
        if(users.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(404);
            errorResponse.setErrorMessage("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        UserResponse userResponse = new UserResponse() ;
        userResponse.setMember_no(users.get(0).getMember_no());
        userResponse.setFirst_name(users.get(0).getFirst_name());
        userResponse.setLast_name(users.get(0).getLast_name());
        userResponse.setEmail(users.get(0).getEmail());
        userResponse.setProfile(users.get(0).getProfile());
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @Override
    public ResponseEntity<?> login(LoginPOJO loginPOJO) throws Exception {
        List<Users> users  = users_repository.fetchUserInfo(loginPOJO.getMember_no().toUpperCase());
        if(users.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(404);
            errorResponse.setErrorMessage("User not found with member number " + loginPOJO.getMember_no().toUpperCase());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        final String dbPassword = users.get(0).getPassword() ;
        final String userPassword = loginPOJO.getPassword() ;

        if (isCorrectPassword(dbPassword, userPassword)) {
            UserResponse userResponse = new UserResponse() ;
            userResponse.setMember_no(users.get(0).getMember_no());
            userResponse.setFirst_name(users.get(0).getFirst_name());
            userResponse.setLast_name(users.get(0).getLast_name());
            userResponse.setEmail(users.get(0).getEmail());
            userResponse.setProfile(users.get(0).getProfile());
            return ResponseEntity.status(HttpStatus.OK).body(userResponse) ;
        }

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(401);
        errorResponse.setErrorMessage("The credentials used are incorrect please try again.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @Override
    public boolean isCorrectPassword(String databasePassword, String userProvidedPassword) throws Exception {
        return encoder.matches(userProvidedPassword, databasePassword);
    }

}
