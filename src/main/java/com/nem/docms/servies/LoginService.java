package com.nem.docms.servies;

import com.nem.docms.entities.User;

public interface LoginService {

	void save(User user);

    User findByUsername(String username);
}
