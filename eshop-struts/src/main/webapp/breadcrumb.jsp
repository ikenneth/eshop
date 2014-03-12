<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="row">
    <div class="col-md-3">
        <ol class="breadcrumb">
            <li>Familles</li>
        </ol>
    </div>
    <div class="col-md-9">
        <ol class="breadcrumb">
            <s:iterator value="#session.breadcrumb.iterator()" status="status">
                <s:if test="!#status.last">
                    <li><s:a action="%{action}"><s:text name="%{key}"/></s:a>
                </s:if>
                <s:else>
                    <li class="active"><s:text name="%{key}"/></li>
                </s:else>
            </s:iterator>
        </ol>
    </div>
</div>
