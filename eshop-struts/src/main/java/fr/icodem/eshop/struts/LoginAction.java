package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import fr.icodem.eshop.exception.AuthenticationException;
import fr.icodem.eshop.model.Customer;
import fr.icodem.eshop.model.User;
import fr.icodem.eshop.service.SecurityService;
import org.apache.struts2.interceptor.SessionAware;

import javax.annotation.Resource;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    @Resource
    private SecurityService service;

    private String username;
    private String password;

    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        try {
            User u = service.authenticate(username, password);
            session.put("user", u);
            return SUCCESS;
        } catch (AuthenticationException ae) {
            addActionError("Authentication failed");
            return LOGIN;
        }
    }

    /*  method validation
    @Override
    public void validate() {
        if ("".equals(username)) {
            addFieldError("username", "Username is required");
        }
        if ("".equals(password)) {
            addFieldError("password", "Password is required");
        }
    }
    */

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    @RequiredStringValidator(message = "You must enter a username")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message = "You must enter a password")
    public void setPassword(String password) {
        this.password = password;
    }

}
