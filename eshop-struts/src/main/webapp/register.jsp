<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="!registrationOK">
    <s:form action="register">
        <s:textfield name="username" key="username"/>
        <s:password name="password1" key="password"/>
        <s:password name="password2" label="Confirm password"/>
        <s:submit value="Register"/>
    </s:form>
</s:if>

<s:if test="registrationOK">
    <s:property value="getText('welcome')"/>
    <s:text name="welcome"/>
    <s:text name="thankyou"/>
</s:if>

<s:if test="hasActionMessages()">
    <div class="message">
        <s:actionmessage/>
    </div>
</s:if>

<s:if test="hasActionErrors()">
    <div class="error">
        <s:actionerror/>
    </div>
</s:if>

<s:a action="login-input">Login</s:a>
