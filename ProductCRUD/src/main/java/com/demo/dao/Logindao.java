package com.demo.dao;

import com.demo.model.MyUser;

public interface Logindao {

	MyUser validate(String uname, String pass);

}
