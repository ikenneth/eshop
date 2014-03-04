package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    private String username;
    private String password;

    private String message;

    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        if ("admin".equals(username) && "admin".equals(password)) {
            message = "";
            session.put("user", "admin");
            return SUCCESS;
        }

        message = "Authentication failed";
        return LOGIN;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
