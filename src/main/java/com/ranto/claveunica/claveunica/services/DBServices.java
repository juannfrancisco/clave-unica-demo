package com.ranto.claveunica.claveunica.services;

import com.ranto.claveunica.claveunica.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBServices {


    public static DB find(String run, String password) throws Exception {
        List<DB> dbs = loadDB();

        Optional<DB>  dbF =  dbs.stream()
                .filter( db -> db.getRun().equals(run) && db.getPassword().equals(password) )
                .findFirst();

        if(dbF.isEmpty() ){
            throw new Exception("Usuario no encontrado");
        }
        return dbF.get();
    }

    public static DB findCodeState(String code, String state) throws Exception {
        List<DB> dbs = loadDB();

        Optional<DB>  dbF =  dbs.stream()
                .filter( db -> db.getCode().equals(code) && db.getState().equals(state) )
                .findFirst();

        if(dbF.isEmpty() ){
            throw new Exception("Usuario no encontrado");
        }
        return dbF.get();
    }

    public static DB findAuth(String auth) throws Exception {
        List<DB> dbs = loadDB();

        Optional<DB>  dbF =  dbs.stream()
                .filter( db -> db.getJson().getAccess_token().equals( auth.split("Bearer")[1].trim() )  )
                .findFirst();

        if(dbF.isEmpty() ){
            throw new Exception("Usuario no encontrado");
        }
        return dbF.get();
    }

    public static List<DB> loadDB(){

        List<DB> dbs = new ArrayList<>();

        String[] nombres1 = {"Juan", "Francisco"};
        String[] apellidos1 = {"Maldonado", "Leon"};
        User user1  = new User( "", new RolUnico("6", 16942332, "RUN"), new Name(nombres1, apellidos1));

        String[] nombres2 = {"David", "Maldonado"};
        String[] apellidos2 = {"Maldonado", "Leon"};
        User user2  = new User( "", new RolUnico("2", 16020016, "RUN"), new Name(nombres2, apellidos2));

        String[] nombres3 = {"Joao", "Paulo"};
        String[] apellidos3 = {"Amestica", "Leon"};
        User user3  = new User( "", new RolUnico("3", 17878771, "RUN"), new Name(nombres3, apellidos3));

        String[] nombres4 = {"Juan", "Francisco"};
        String[] apellidos4 = {"Maldonado", "Leon"};
        User user4  = new User( "", new RolUnico("9", 12345678, "RUN"), new Name(nombres4, apellidos4));

        TokenResponse response1 = new TokenResponse("75104ab471534af08683aefa7d0935a3", "bearer", 3600, "eyJhbGciOiJSUzI1NiIsIm6Ijg1ZGVjMDU1MjZmNjUwZlMTI4NTc3NGM3In075104ab471534af08683aefa7d0935a3");
        TokenResponse response2 = new TokenResponse("85104ab471534af08683aefa7d0935a3", "bearer", 3600, "eyJhbGciOiJSUzI1NiIsIm6Ijg1ZGVjMDU1MjZmNjUwZlMTI4NTc3NGM3In085104ab471534af08683aefa7d0935a3");
        TokenResponse response3 = new TokenResponse("95104ab471534af08683aefa7d0935a3", "bearer", 3600, "eyJhbGciOiJSUzI1NiIsIm6Ijg1ZGVjMDU1MjZmNjUwZlMTI4NTc3NGM3In095104ab471534af08683aefa7d0935a3");
        TokenResponse response4 = new TokenResponse("45104ab471534af08683aefa7d0935a3", "bearer", 3600, "eyJhbGciOiJSUzI1NiIsIm6Ijg1ZGVjMDU1MjZmNjUwZlMTI4NTc3NGM3In045104ab471534af08683aefa7d0935a3");




        DB db1 = new DB( "169423326" , "169423326", "1", "1", response1,  user1 );
        DB db2 = new DB( "160200162" , "160200162", "2", "2", response2,  user2 );
        DB db3 = new DB( "178787713" , "178787713", "3", "3", response3,  user3 );
        DB db4 = new DB( "123456789" , "123456789", "4", "4", response4,  user4 );

        dbs.add(db1);
        dbs.add(db2);
        dbs.add(db3);
        dbs.add(db4);
        return dbs;
    }



}
