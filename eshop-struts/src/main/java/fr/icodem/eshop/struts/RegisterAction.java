package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import fr.icodem.eshop.exception.RegistrationException;
import fr.icodem.eshop.model.Registration;
import fr.icodem.eshop.service.SecurityService;

import javax.annotation.Resource;

public class RegisterAction extends ActionSupport implements Preparable {

    @Resource
    private SecurityService service;

    private Registration registration;

    @Override
    public void prepare() throws Exception {
        registration = new Registration();
    }

    public String execute() throws Exception {
        try {
            service.register(registration);
        } catch (RegistrationException re) {
            addFieldError("registration.username", getText("user-already-used"));
            return INPUT;
        }

        return SUCCESS;
    }

    // getters and setters
    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

}
