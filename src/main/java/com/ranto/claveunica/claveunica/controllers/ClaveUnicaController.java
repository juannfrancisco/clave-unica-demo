package com.ranto.claveunica.claveunica.controllers;

import com.ranto.claveunica.claveunica.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;

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
        System.out.println(login.getRedirect_uri());
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(login.getRedirect_uri()+"?code=wd&state=asd"))
                .build();
    }

    @PostMapping(  path = "openid/token" , consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<TokenResponse> token(TokenRequest request){
        TokenResponse response = new TokenResponse(
                "95104ab471534af08683aefa7d0935a3",
                "bearer",
                3600,
                "eyJhbGciOiJSUzI1NiIsIm6Ijg1ZGVjMDU1MjZmNjUwZlMTI4NTc3NGM3In0"
        );
        return new ResponseEntity<>( response, HttpStatus.OK ) ;
    }

    @PostMapping("openid/userinfo")
    public ResponseEntity<User> userInfo(){
        User user = new User();
        user.setSub( "1234567" );
        RolUnico rolUnico = new RolUnico();
        rolUnico.setDV("9");
        rolUnico.setNumero(12345678);
        rolUnico.setTipo("RUN");
        user.setRolUnico(rolUnico);
        String[] nombre = {"juan", "francisco"};
        String[] apellidos = {"maldonado", "silva"};
        user.setName( new Name(nombre, apellidos));
        return new ResponseEntity<>( user, HttpStatus.OK ) ;
    }


}
