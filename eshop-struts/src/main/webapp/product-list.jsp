<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<%--
<s:select name="familyId" list="families" listKey="id" listValue="name"
          headerValue="Select a family..." value="%{families.{id}}"/>

<s:combobox list="families" label="Famille" name="familyId" headerKey="-1" headerValue="XXX" emptyOption="true" value="2"
            listKey="id" listValue="name"/>

<s:radio list="{'male', 'female'}" label="Gender" name="gender"/>
--%>

<s:iterator value="products">
    <div class="row product-list">
        <div class="col-sm-2">
            <s:if test="image != null">
                <s:url action="product-image" var="productImage">
                    <s:param name="imageId"><s:property value="image.id"/></s:param>
                </s:url>
            </s:if>
            <s:else>
                <s:url value="images/no-image.png" var="productImage"/>
            </s:else>
            <s:set value="productImage" var="productImage" scope="page"/>
            <img src="${productImage}" width="75" />
        </div>
        <div class="col-sm-7">
            <h4>
                <s:a action="product-detail">
                    <s:property value="name"/>
                    <s:param name="productId"><s:property value="id"/></s:param>
                </s:a>
            </h4>
            <div><s:property value="getDescription(description)"/></div>
        </div>
        <div class="col-sm-1"></div>
        <div class="col-sm-2">
            <p>
                <s:text name="format.money">
                    <s:param name="value" value="price"/>
                </s:text>
            </p>

            <s:a action="cart-add-item" cssClass="btn btn-primary">
                <span class="glyphicon glyphicon-shopping-cart"></span> Ajouter
                <s:param name="keyword"><s:property value="keyword"/></s:param>
                <s:param name="familyId"><s:property value="familyId"/></s:param>
                <s:param name="productId"><s:property value="id"/></s:param>
                <s:param name="quantity">1</s:param>
                <s:param name="from">product-list</s:param>
            </s:a>
        </div>
        <div class="col-sm-12">
            <hr/>
        </div>
    </div>
</s:iterator>
