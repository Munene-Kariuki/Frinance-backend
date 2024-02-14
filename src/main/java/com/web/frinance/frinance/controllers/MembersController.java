package com.web.frinance.frinance.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/")
public class MembersController {
    @RequestMapping( path = "shares/", method = RequestMethod.POST)
    public String createCustomerService() throws Exception {
        return null;
    }
}
