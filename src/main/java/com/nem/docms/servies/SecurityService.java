package com.nem.docms.servies;

public interface SecurityService {
	
	String findLoggedInUsername();

    void autoLogin(String username, String password);
}
