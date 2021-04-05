package cz.educanet.javaeeapi;

import cz.educanet.javaeeapi.UsersManager;

import javax.inject.Inject;
import java.util.ArrayList;

public class AuthenticationManager {

    @Inject
    UsersManager usersManager;

    private ArrayList<String> tokenList = new ArrayList<String>();
}

