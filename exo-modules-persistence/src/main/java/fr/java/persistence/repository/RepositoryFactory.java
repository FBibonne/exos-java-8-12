package fr.java.persistence.repository;

import fr.java.persistence.repository.impl.UserRepositoryImpl;

public interface RepositoryFactory {
	
	public static UserRepository createUser() {
		return new UserRepositoryImpl();
	}

}
