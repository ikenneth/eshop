package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

public class ProductImageResult implements Result {

    @Override
    public void execute(ActionInvocation invocation) throws Exception {
        ProductImageAction action = (ProductImageAction) invocation.getAction();
        HttpServletResponse resp = ServletActionContext.getResponse();

        resp.setContentType("image/png");
        resp.getOutputStream().write(action.getContent());
    }
}
