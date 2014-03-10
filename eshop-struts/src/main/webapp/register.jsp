<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h2><s:text name="create-account"/></h2>
<hr>

<s:form action="register" theme="simple">
    <div class="row">
        <div class="col-md-5">
            <h3><s:text name="personal-data"/></h3>
            <hr>
            <div class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="firstNameInput" class="control-label col-sm-2">
                        <s:text name="first-name"/>
                    </label>
                    <div class="col-sm-10">
                        <s:textfield name="registration.firstName" id="firstNameInput"
                                     cssClass="form-control" theme="simple"/>
                        <s:fielderror fieldName="registration.firstName" theme="eshop"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastNameInput" class="control-label col-sm-2">
                        <s:text name="lastName"/>
                    </label>
                    <div class="col-sm-10">
                        <s:textfield name="registration.lastName" id="lastNameInput"
                                     cssClass="form-control" theme="simple"/>
                        <s:fielderror fieldName="registration.lastName" theme="eshop"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-7">
            <h3><s:text name="address"/></h3>
            <hr>
            <div class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="streetInput" class="control-label col-sm-3">
                        <s:text name="street"/>
                    </label>
                    <div class="col-sm-9">
                        <s:textfield name="registration.street" id="streetInput"
                                     cssClass="form-control" theme="simple"/>
                        <s:fielderror fieldName="registration.street" theme="eshop"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="cityInput" class="control-label col-sm-3">
                        <s:text name="city"/>
                    </label>
                    <div class="col-sm-9">
                        <s:textfield name="registration.city" id="cityInput"
                                     cssClass="form-control" theme="simple"/>
                        <s:fielderror fieldName="registration.city" theme="eshop"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="zipCodeInput" class="control-label col-sm-3">
                        <s:text name="post-code"/>
                    </label>
                    <div class="col-sm-9">
                        <s:textfield name="registration.postCode" id="zipCodeInput"
                                     cssClass="form-control" theme="simple"/>
                        <s:fielderror fieldName="registration.postCode" theme="eshop"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h3><s:text name="connection-info"/></h3>
            <hr>
        </div>
        <div class="col-md-5">
            <div class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="emailInput" class="control-label col-sm-2">
                        <s:text name="mail"/>
                    </label>
                    <div class="col-sm-10">
                        <s:textfield name="registration.username" id="emailInput" type="email"
                                     cssClass="form-control" theme="simple"/>
                        <s:fielderror fieldName="registration.username" theme="eshop"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-7">
            <div class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="passwordInput" class="control-label col-sm-3">
                        <s:text name="password"/>
                    </label>
                    <div class="col-sm-9">
                        <s:password name="registration.password1" id="passwordInput"
                                     cssClass="form-control" theme="simple"/>
                        <s:fielderror fieldName="registration.password1" theme="eshop"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmPasswordInput" class="control-label col-sm-3">
                        <s:text name="confirm-password"/>
                    </label>
                    <div class="col-sm-9">
                        <s:password name="registration.password2" id="confirmPasswordInput"
                                     cssClass="form-control" theme="simple"/>
                        <s:fielderror fieldName="registration.password2" theme="eshop"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <button type="submit" class="btn btn-primary pull-right">
                <s:text name="register"/>
            </button>
        </div>
    </div>

</s:form>

<%--
    <s:if test="hasActionMessages()">
        <s:actionmessage/>
    </s:if>
    <s:if test="hasActionErrors()">
        <s:actionerrors/>
    </s:if>
--%>

