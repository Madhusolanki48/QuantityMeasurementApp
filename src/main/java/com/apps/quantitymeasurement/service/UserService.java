package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.entity.User;
import com.apps.quantitymeasurement.repository.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository repo;

	public UserService(UserRepository repo) {
		this.repo = repo;
	}

	public void saveUser(OAuth2User oAuthUser) {

	    String email = oAuthUser.getAttribute("email");
	    String name = oAuthUser.getAttribute("name");
	    System.out.println("OAuth Attributes: " + oAuthUser.getAttributes());

	    // fallback handling
	    if (email == null) {
	        email = oAuthUser.getAttribute("preferred_username");
	    }

	    if (name == null) {
	        name = oAuthUser.getAttribute("given_name");
	    }

	    if (email == null) {
	        throw new RuntimeException("Email not found from Google OAuth");
	    }

	    String finalEmail = email;
	    String finalName = (name != null) ? name : "User";

	    repo.findByEmail(finalEmail).orElseGet(() ->
	        repo.save(new User(finalName, finalEmail, "GOOGLE"))
	    );
	}
}