<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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


<br><br>

<h2>Créer un compte</h2>
<hr>

<div class="row">
    <div class="col-md-6">
        <h3>Vos informations personnelles</h3>
        <hr>
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="firstNameInput" class="control-label col-sm-2">Prénom</label>
                <div class="col-sm-10">
                    <input id="firstNameInput" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="lastNameInput" class="control-label col-sm-2">Nom</label>
                <div class="col-sm-10">
                    <input id="lastNameInput" type="text" class="form-control"/>
                </div>
            </div>
        </form>
    </div>

    <div class="col-md-6">
        <h3>Votre adresse</h3>
        <hr>
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="streetInput" class="control-label col-sm-2">Rue</label>
                <div class="col-sm-10">
                    <input id="streetInput" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="cityInput" class="control-label col-sm-2">Ville</label>
                <div class="col-sm-10">
                    <input id="cityInput" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="zipCodeInput" class="control-label col-sm-2">Code postal</label>
                <div class="col-sm-10">
                    <input id="zipCodeInput" type="text" class="form-control"/>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <h3>Vos informations de connexion</h3>
        <hr>
    </div>
    <div class="col-md-6">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="emailInput" class="control-label col-sm-2">Mail</label>
                <div class="col-sm-10">
                    <input id="emailInput" type="email" class="form-control"/>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-6">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="passwordInput" class="control-label col-sm-2">Mot de passe</label>
                <div class="col-sm-10">
                    <input id="passwordInput" type="password" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="confirmPasswordInput" class="control-label col-sm-2">Confirmer le mot de passe</label>
                <div class="col-sm-10">
                    <input id="confirmPasswordInput" type="password" class="form-control"/>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="row">
    <div class="col-sm-12">
        <button type="submit" class="btn btn-primary pull-right">S'incrire</button>
    </div>
</div>

<br><br>

