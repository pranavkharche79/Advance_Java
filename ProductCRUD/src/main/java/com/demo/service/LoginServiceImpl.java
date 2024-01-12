package com.demo.service;

import com.demo.dao.Logindao;
import com.demo.dao.LogindaoImpl;
import com.demo.model.MyUser;

public class LoginServiceImpl implements LoginService 
{
	static Logindao ldao;
	static {
		ldao=new LogindaoImpl();
	}
	@Override
	public MyUser validate(String uname, String pass) {
		// TODO Auto-generated method stub
		return ldao.validate(uname,pass);
	}

}
