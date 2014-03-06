package fr.icodem.eshop.service;

import fr.icodem.eshop.exception.AuthenticationException;
import fr.icodem.eshop.exception.RegistrationException;
import fr.icodem.eshop.model.Registration;
import fr.icodem.eshop.model.User;

public interface SecurityService {
    User authenticate(String username, String password) throws AuthenticationException;

    void register(Registration registration) throws RegistrationException;

}
