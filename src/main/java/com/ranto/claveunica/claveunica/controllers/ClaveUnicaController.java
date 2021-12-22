package com.ranto.claveunica.claveunica.controllers;

import com.ranto.claveunica.claveunica.model.*;
import com.ranto.claveunica.claveunica.services.DBServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ClaveUnicaController {


    @GetMapping( "openid/authorize/" )
    public ModelAndView authorize(
            @RequestParam( name ="client_id", required = false) String client_id,
            @RequestParam( name ="response_type", required = false) String response_type,
            @RequestParam( name ="scope", required = false) String scope,
            @RequestParam( name ="redirect_uri", required = false) String redirect_uri,
            @RequestParam( name ="state", required = false) String state
    ){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "client_id", client_id);
        modelAndView.addObject( "response_type", response_type);
        modelAndView.addObject( "scope", scope);
        modelAndView.addObject( "redirect_uri", redirect_uri);
        modelAndView.addObject( "state", state);

        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping( path="login", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
    public ResponseEntity<Void> login(LoginRequest login){

        try {
            DB db = DBServices.find(login.getRun(), login.getPassword());
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .location(URI.create(login.getRedirect_uri()+"?code="+db.getCode()+"&state="+db.getState()))
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).build();
        }

    }

    @PostMapping(  path = "openid/token" , consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<TokenResponse> token(TokenRequest request){
        try{
            DB db = DBServices.findCodeState(request.getCode(), request.getState());
            return new ResponseEntity<>( db.getJson(), HttpStatus.OK ) ;
        }catch (Exception ex){
            return  ResponseEntity.status( HttpStatus.NOT_FOUND ).build();
        }
    }

    @PostMapping("openid/userinfo")
    public ResponseEntity<User> userInfo( @RequestHeader("Authorization") String auth ){
        try {
            DB db = DBServices.findAuth(auth);
            return new ResponseEntity<>( db.getUser(), HttpStatus.OK ) ;
        }catch (Exception e){
            return  ResponseEntity.status( HttpStatus.NOT_FOUND ).build();
        }
    }


}
