<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<h2>Authentication</h2>

<s:form action="login">
    <s:textfield name="username" key="username"/>
    <s:password name="password" label="%{getText('password')}"/>
    <s:submit value="OK"/>
</s:form>

<s:fielderror fieldName="username"/>

<s:if test="%{message != null}">
    <span style="color:red;">
        <s:property value="message"/>
    </span>
</s:if>

<s:if test="hasActionErrors()">
    <div class="error">
        <s:actionerror/>
    </div>
</s:if>

<s:url action="register-input" var="registerLink"/>
<a href="${registerLink}">Register</a>
<a href="registerInput.action">Register</a>
<s:a action="register-input">Register</s:a>
