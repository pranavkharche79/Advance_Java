package com.demo.service;

import com.demo.model.MyUser;

public interface LoginService {

	MyUser validate(String uname, String pass);

}
