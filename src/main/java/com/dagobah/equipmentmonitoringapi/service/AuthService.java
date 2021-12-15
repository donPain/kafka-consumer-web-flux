///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.dagobah.equipmentmonitoringapi.service;
//
//import com.solinftec.auth.lib.service.sgpa.AuthBuilder;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author donzelitos
// */
//@Component
//public class AuthService {
//
//    String url = "https://auth-api.saas-solinftec.com/v2";
//
//    private final AuthBuilder auth;
//
//    public AuthService() {
//        this.auth = new AuthBuilder(url, "equipment-status-monitoring");
//    }
//
//    public String getToken(String user, String password, String owner) {
//        return this.auth.authenticate(user, password, owner).generateToken().getToken();
//    }
//
//}
