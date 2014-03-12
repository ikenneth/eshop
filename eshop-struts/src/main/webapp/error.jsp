<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Erreur</title>

    <meta charset="UTF-8">

    <!-- Bootstrap & main CSS -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">

</head>
<body>
    <div class="alert alert-danger">
        <strong><s:text name="error.title"/></strong> <s:text name="error.message"/>

        <s:debug>
            <hr>
            <div class="well">
                <s:property value="exceptionStack"/>
                <s:property value="exception.message"/>
            </div>
        </s:debug>
    </div>
</body>