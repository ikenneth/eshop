package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class BreadcrumbInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // get breadcrumb stack from session
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        BreadcrumbStack stack = (BreadcrumbStack) session.get("breadcrumb");
        if (stack == null) {
            stack = new BreadcrumbStack();
            stack.addItem("product-list", "home");
            session.put("breadcrumb", stack);
        }

        // breadcrumb logic
        String action = invocation.getInvocationContext().getName();
        switch (action) {
            case "product-list":
                stack.clearAndKeepFirst();
                break;
            case "product-detail":
                if (!stack.isLast("order-list") && !stack.isLast("cart-input")) {
                    stack.clearAndKeepFirst();
                }
                stack.addItem(action, "product-detail");
                break;
            case "cart":
                stack.clearAndKeepFirst();
                stack.addItem("cart-input", "cart");
                break;
            case "cart-input":
                stack.clearAndKeepFirst();
                stack.addItem(action, "cart");
                break;
            case "order-list":
                stack.clearAndKeepFirst();
                stack.addItem(action, "my-orders");
                break;
            case "login":
                action = "login-input";
            case "login-input":
                stack.clearAndKeepFirst();
                stack.addItem(action, "login");
                break;
            case "logout":
                stack.clearAndKeepFirst();
                stack.addItem(action, "logout");
            case "about":
                stack.clearAndKeepFirst();
                stack.addItem(action, "about");
                break;
            case "register-input":
            case "register":
                if (!stack.isLast("login") && !stack.isLast("login-input")) {
                    stack.clearAndKeepFirst();
                }
                stack.addItem("register-input", "register");
                break;
        }

        // invoke action
        return invocation.invoke();
    }
}
