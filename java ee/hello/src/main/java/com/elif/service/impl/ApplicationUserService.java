package com.elif.service.impl;

import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.elif.entity.ApplicationUser;
import com.elif.util.SecurityUtil;

@Transactional
public class ApplicationUserService {

	
	@PersistenceContext
	private EntityManager entityManager; // This is JPA provider entity provider.
	
    @Inject
    private SecurityUtil securityUtil;


	public ApplicationUser save(ApplicationUser t) {
		Map<String, String> credMap = securityUtil.hashPassword(t.getPassword());

		t.setHashedPassword(credMap.get("hashedPassword"));
		t.setSalt(credMap.get("salt"));

		if (t.getId() == null) {
			entityManager.persist(t);
		} else {
			entityManager.merge(t);
		}
		
		 credMap = null;

		return t;
	}

	public void delete(ApplicationUser t) {
		if (!entityManager.contains(t)) {
		    t = entityManager.merge(t);
		}
		entityManager.remove(t);		
	}
	
	 public boolean authenticateUser(String email, String plainTextPassword) {

	        ApplicationUser user = entityManager.createNamedQuery(ApplicationUser.FIND_USER_BY_CREDENTIALS, ApplicationUser.class)
	                .setParameter("email", email.toLowerCase()).getResultList().get(0);

	        if (user != null) {
	            return securityUtil.passwordsMatch(user.getHashedPassword(), user.getSalt(), plainTextPassword);
	        }
	        return false;

	    }
}
