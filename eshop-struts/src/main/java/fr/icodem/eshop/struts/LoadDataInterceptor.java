package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import fr.icodem.eshop.model.Cart;
import fr.icodem.eshop.model.ProductFamily;
import fr.icodem.eshop.service.CatalogService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class LoadDataInterceptor extends AbstractInterceptor {

    @Resource
    private CatalogService service;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = invocation.getInvocationContext();
        Map<String, Object> session = ctx.getSession();

        // load families in session
        if (session.get("families") == null) {
            List<ProductFamily> families = service.findFamilies();
            session.put("families", families);
        }

        // initialize cart in session
        if (session.get("cart") == null) {
            session.put("cart", new Cart());
        }

        return invocation.invoke();
    }


}
