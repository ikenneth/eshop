<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h2><s:text name="registration-completed"/></h2>
<hr>

<div class="row">
    <div class="col-md-12">
            <p><s:text name="thankyou"/></p>
        </div>
    </div>
<div class="row">
    <div class="col-md-12">
        <s:a action="login-input" cssClass="btn btn-primary pull-right">
            <s:text name="login"/>
        </s:a>
    </div>
</div>







