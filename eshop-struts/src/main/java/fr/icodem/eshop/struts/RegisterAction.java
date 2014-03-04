package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

    private String username;
    private String password1;
    private String password2;

    private boolean registrationOK;

    public String execute() throws Exception {
        if ("admin".equals(username)) {
            addActionError("This username is already used");
            return INPUT;
        }

        registrationOK = true;
        addActionMessage("You are now registered");
        return SUCCESS;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public boolean isRegistrationOK() {
        return registrationOK;
    }

    public void setRegistrationOK(boolean registrationOK) {
        this.registrationOK = registrationOK;
    }
}
