package fr.icodem.eshop.service;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import fr.icodem.eshop.dto.UserDto;

import javax.persistence.EntityManager;

@Transactional
public class AccountService {
    @Inject
    private Provider<EntityManager> entityManagerProvider;

    public UserDto findUser(String email) {
        switch (email) {
            case "john@mail.com":
                return new UserDto("john", "John", "Doe");
            case "admin":
                return new UserDto("admin", "Administrator", "");
        }
        return null;
    }
}
