package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LogoutAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        session.remove("user");
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


}
