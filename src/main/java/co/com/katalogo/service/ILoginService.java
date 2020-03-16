package co.com.katalogo.service;

import org.apache.catalina.User;

public interface ILoginService {
	void save(User user);
	User findByUsername(String username);
}
