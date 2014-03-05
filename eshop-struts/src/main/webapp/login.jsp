<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<h2>Authentification</h2>
<hr/>

<div class="row">
    <div class="col-md-6">
        <div class="well well-sm">
            <h3>Inscription</h3>
            <p>Vous pouvez vous incrire</p>
            <div class="row">
                <div class="col-sm-12">
                    <s:a action="register-input" cssClass="btn btn-primary pull-right">Créer un compte</s:a>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-6">
        <div class="well well-sm">
            <h3>J'ai un compte</h3>
            <s:form action="login" role="form">
                <div class="form-group">
                    <label for="emailInput" class="control-label">Votre email</label>
                    <s:textfield name="username" id="emailInput" type="email" theme="simple"
                                 placeholder="Entrez votre mail" cssClass="form-control"/>
                    <s:fielderror fieldName="username" theme="eshop"/>
                </div>
                <div class="form-group">
                    <label for="passwordInput" class="control-label"><s:text name="password"/></label>
                    <s:password name="password" id="passwordInput" theme="simple"
                                placeholder="Entrez votre mot de passe" cssClass="form-control"/>
                    <s:fielderror fieldName="password" theme="eshop"/>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <button type="submit" class="btn btn-primary pull-right">Valider</button>
                    </div>
                </div>
            </s:form>
        </div>
    </div>
</div>

<%--  Simple form example
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
--%>


