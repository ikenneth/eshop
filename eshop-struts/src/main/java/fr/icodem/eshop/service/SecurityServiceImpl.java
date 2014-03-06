package fr.icodem.eshop.service;

import fr.icodem.eshop.exception.AuthenticationException;
import fr.icodem.eshop.exception.RegistrationException;
import fr.icodem.eshop.model.Address;
import fr.icodem.eshop.model.Customer;
import fr.icodem.eshop.model.Registration;
import fr.icodem.eshop.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SessionFactory sf;

    @Override
    public User authenticate(String username, String password) throws AuthenticationException {
        Session session = sf.getCurrentSession();
        User u = (User) session.get(User.class, username);
        if (u == null || !password.equals(u.getPassword())) {
            throw new AuthenticationException("Authentication failed : " + username);
        }
        return u;
    }

    @Override
    public void register(Registration registration) throws RegistrationException {
        Session session = sf.getCurrentSession();

        User u = (User) session.get(User.class, registration.getUsername());
        if (u != null) {
            throw new RegistrationException("This username is already used");
        }

        // create new customer
        Customer c = new Customer();
        c.setUsername(registration.getUsername());
        c.setPassword(registration.getPassword1());
        c.setFirstName(registration.getFirstName());
        c.setLastName(registration.getLastName());

        Address a = new Address();
        a.setStreet(registration.getStreet());
        a.setCity(registration.getCity());
        a.setPostCode(registration.getPostCode());
        a.setCountry(registration.getCountry());

        c.setAddress(a);

        session.save(c);
    }
}
